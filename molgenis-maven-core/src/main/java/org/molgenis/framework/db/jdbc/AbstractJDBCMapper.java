package org.molgenis.framework.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.molgenis.fieldtypes.DecimalField;
import org.molgenis.fieldtypes.FieldType;
import org.molgenis.fieldtypes.IntField;
import org.molgenis.fieldtypes.LongField;
import org.molgenis.fieldtypes.StringField;
import org.molgenis.fieldtypes.TextField;
import org.molgenis.framework.db.AbstractMapper;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.Query;
import org.molgenis.framework.db.QueryRule;
import org.molgenis.framework.db.QueryRule.Operator;
import org.molgenis.model.MolgenisModelException;
import org.molgenis.model.elements.Field;
import org.molgenis.util.Entity;
import org.molgenis.util.Tuple;
import org.molgenis.util.TupleWriter;

/**
 * Factory for creating SQL statements
 * 
 * @author Morris Swertz
 * 
 */
public abstract class AbstractJDBCMapper<E extends Entity> extends AbstractMapper<E>
{
	/** log messages */
	private static final Logger logger = Logger.getLogger(AbstractJDBCMapper.class);

	public AbstractJDBCMapper(Database database)
	{
		super(database);
	}

	@Override
	public void find(TupleWriter writer, List<String> fieldsToExport, QueryRule[] rules) throws DatabaseException
	{
		try
		{
			// streaming result!!!!
			List<Tuple> rsList = executeSelect(rules);

			/*
			 * logger.debug("executeSelect(rules)"); for(QueryRule q : rules){
			 * logger.debug("rule: " + q.toString()); }
			 */
			// transform result set in writer
			E entity = create();
			List<String> fields = fieldsToExport;
			if (fieldsToExport == null) fields = entity.getFields();

			writer.setHeaders(fields);
			writer.writeHeader();
			int i = 0;
			List<E> entityBatch = new ArrayList<E>();
			for (Tuple rs : rsList)
			{
				entity = create();
				entity.set(rs);
				entityBatch.add(entity);
				i++;

			}
			// write remaining
			// load mrefs
			logger.debug("*** mapMrefs -> LEFTOVERS"); // program does NOT crash
														// after this
			mapMrefs(entityBatch);
			for (E e : entityBatch)
			{
				writer.writeRow(e);
			}
			entityBatch.clear();
			writer.close();

			logger.debug("find(" + create().getClass().getSimpleName() + ", TupleWriter, " + Arrays.asList(rules)
					+ "): wrote " + i + " lines.");
		}
		catch (Exception e)
		{
			throw new DatabaseException(e);
		}
	}

	/**
	 * Helper method for retrieving keys.
	 * 
	 * @param entities
	 * @param fromIndex
	 * @param stmt
	 * @throws DatabaseException
	 */
	public void getGeneratedKeys(List<? extends E> entities, Statement stmt, int fromIndex) throws DatabaseException
	{
		E entity = null;
		ResultSet rs_keys = null;
		int i = 0;
		try
		{
			rs_keys = stmt.getGeneratedKeys();
			while (rs_keys.next())
			{
				entity = entities.get(fromIndex + i);
				setAutogeneratedKey(rs_keys.getInt(1), entity);
				i++;
			}
		}
		catch (Exception e)
		{
			logger.error("executeKeys(): " + e);
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		finally
		{
			try
			{
				rs_keys.close();
			}
			catch (Exception e)
			{
			}
			rs_keys = null;
		}
	}

	/**
	 * maps {@link org.molgenis.framework.db.Database#find(Class, QueryRule[])}
	 * 
	 * @throws DatabaseException
	 */
	public abstract String createFindSql(QueryRule... rules) throws DatabaseException;

	/**
	 * maps {@link org.molgenis.framework.db.Database#count(Class, QueryRule[])}
	 * 
	 * @throws DatabaseException
	 * 
	 * @throws DatabaseException
	 * 
	 * @throws SQLException
	 */
	public abstract String createCountSql(QueryRule... rules) throws DatabaseException;

	/**
	 * Translate object field name to table fieldname
	 */
	@Override
	public abstract String getTableFieldName(String fieldName);

	/**
	 * Retrieve the type of the field
	 */
	@Override
	public abstract FieldType getFieldType(String fieldName);

	/**
	 * helper method to set the auto-generated keys
	 */
	public abstract void setAutogeneratedKey(int key, E entity);

	/**
	 * helper method for mapping multiplicative references (mref). This function
	 * is used when retrieving the entity. It should retrieve the mref elements
	 * and add them to each mref field.
	 * 
	 * @param entities
	 * @throws DatabaseException
	 */
	public abstract void mapMrefs(List<E> entities) throws DatabaseException;

	/**
	 * Rewrite mref rules: mref fields are actually not in the table but in a
	 * link table. To filter on an mref id or mref label one has to first query
	 * this table to extract ids for 'this' table. This function provides the
	 * functionality therefore.
	 * 
	 * @param db
	 * @param user_rule
	 *            the original rule
	 * @return a rewritten rule for mrefs, typically of the form 'id' IN 'list
	 *         of ids'
	 * @throws DatabaseException
	 */
	protected abstract QueryRule rewriteMrefRule(Database db, QueryRule user_rule) throws DatabaseException;

	@Override
	public int count(QueryRule... rules) throws DatabaseException
	{
		try
		{
			String sql = createCountSql(rules) + createWhereSql(false, true, this.rewriteRules(getDatabase(), rules));
			// + createWhereSql(getMapperFor(klazz), false, true, rules);
			List<Tuple> rsList = getDatabase().sql(sql);
			int result = rsList.get(0).getInt("num_rows");
			logger.debug("counted " + result + " " + this.create().getClass().getSimpleName() + " objects");
			return result;
		}
		catch (Exception e)
		{
			throw new DatabaseException(e);
		}
	}

	@Override
	public List<E> find(QueryRule... rules) throws DatabaseException
	{
		try
		{
			List<Tuple> rsList = executeSelect(rules);
			// transform result set in entity list
			List<E> entities = createList(10);
			for (Tuple rs : rsList)
			{
				E entity = create();
				entity.set(rs);
				entities.add(entity);
			}

			// load mrefs
			mapMrefs(entities);

			logger.debug(entities.size() + " " + create().getClass().getSimpleName() + " objects found");
			return entities;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new DatabaseException(e);
		}
	}

	/**
	 * Helper function of various find functions.
	 * 
	 * @param <E>
	 * @param klazz
	 * @param rules
	 * @return
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	private List<Tuple> executeSelect(QueryRule... rules) throws DatabaseException, SQLException
	{
		String sql = createFindSqlInclRules(rules);
		if (rules != null)
		{
			// FIXME too complicated
			for (QueryRule rule : rules)
			{
				if (rule.getOperator() == Operator.LAST)
				{
					sql = "select * from (" + sql + ") as " + this.getClass().getSimpleName().toLowerCase() + " "
							+ createSortSql(true, rules);
					break;
				}
			}
		}
		// execute the query
		// logger.info("TEST\n"+sql);
		return getDatabase().sql(sql);
	}

	/**
	 * Helper method for creating an escaped sql string for a value.
	 * <p>
	 * This can be used by createXXXsql methods to prevend sql-injection in data
	 * values.
	 * 
	 * @param value
	 *            to be escaped
	 */
	public static String escapeSql(Object value)
	{
		if (value != null)
		{
			String result = StringEscapeUtils.escapeSql(value.toString());
			// odd case: if ends with \ we are in trouble
			if (result.endsWith("\\"))
			{
				result += "\\";
			}
			return result;
		}
		return null;
		// return sql.toString().replace("'", "''");
	}

	@Override
	public String createFindSqlInclRules(QueryRule[] rules) throws DatabaseException
	{
		return createFindSql() + createWhereSql(false, true, this.rewriteRules(getDatabase(), rules));
	}

	/**
	 * Mref fields do not really exist in the table but instead in a separate
	 * link table. This method should query this link table to rewrite the query
	 * rules.
	 * 
	 * @param db
	 * @param user_rules
	 * @return
	 * @throws DatabaseException
	 */
	protected QueryRule[] rewriteRules(Database db, QueryRule... user_rules) throws DatabaseException
	{
		if (user_rules == null) return null;
		List<QueryRule> rules = this.rewriteRules(db, Arrays.asList(user_rules));
		return rules.toArray(new QueryRule[rules.size()]);

	}

	/**
	 * Mref fields do not really exist in the table but instead in a separate
	 * link table. This method should query this link table to rewrite the query
	 * rules.
	 * 
	 * @param db
	 * @param user_rules
	 * @return
	 * @throws DatabaseException
	 */
	protected List<QueryRule> rewriteRules(Database db, List<QueryRule> user_rules) throws DatabaseException
	{
		List<QueryRule> rules = new ArrayList<QueryRule>();
		for (QueryRule rule : user_rules)
		{
			if (rule.getOperator() != null && rule.getOperator().equals(Operator.NESTED))
			{
				QueryRule r = new QueryRule(this.rewriteRules(db, rule.getNestedRules()));
				// r.setOr(rule.isOr());
				// rules.add(new QueryRule(Operator.AND));
				rules.add(r);
			}
			else
			{
				QueryRule r = this.rewriteMrefRule(db, rule);
				// r.setOr(rule.isOr());
				// rules.add(new QueryRule(Operator.OR));
				rules.add(r);
			}
		}
		return rules;
	}

	/**
	 * Helper method for creating a where clause from QueryRule...rules.
	 * 
	 * @param mapper
	 *            mapper that is used to extract metadata to create the
	 * @param isNested
	 *            wether this whereclause will be nested inside another clause,
	 *            e.g (A AND B) OR C. If nested then the word "where" will not
	 *            be included in the returned string so this method can be used
	 *            recursively.
	 * @param withOffset
	 *            whether this whereclause should be calculated including offset
	 *            and limit
	 * @param rules
	 *            query rules to be translated into sql where clause.
	 * @return sql where clause. FIXME: remove the 'withOffset' part?
	 * @throws DatabaseException
	 */
	public String createWhereSql(boolean isNested, boolean withOffset, QueryRule... rules) throws DatabaseException
	{
		StringBuilder where_clause = new StringBuilder("");
		QueryRule previousRule = new QueryRule(Operator.AND);
		if (rules != null)
		{
			for (QueryRule r : rules)
			{
				// logger.debug(r);
				// skip OR and AND operators
				if (r.getOperator().equals(Operator.OR) || r.getOperator().equals(Operator.AND))
				{
					previousRule = r;
				}
				else
				{
					QueryRule rule = new QueryRule(r); // copy because of side
					// effects
					// logger.debug(rule);

					// String tablePrefix = "";
					rule.setField(getTableFieldName(rule.getField()));

					if (rule.getOperator() == Operator.LAST || rule.getOperator() == Operator.LIMIT
							|| rule.getOperator() == Operator.OFFSET || rule.getOperator() == Operator.SORTASC
							|| rule.getOperator() == Operator.SORTDESC)
					{

					}
					else if (rule.getOperator() == QueryRule.Operator.SEARCH)
					{
						// naive implementation, should use hibernate search
						// when it comes
						// available!
						List<QueryRule> searchRules = new ArrayList<QueryRule>();

						try
						{
							boolean addAND = false;

							// try create big OR filter for all fields and all
							// search elements
							// todo: enable string term concat using quotes
							if (rule.getValue() != null && !rule.getValue().equals("")) for (String term : rule
									.getValue().toString().split(" "))
							{
								List<QueryRule> termRules = new ArrayList<QueryRule>();

								// create different query rule depending on type
								List<Field> fields = getDatabase().getMetaData()
										.getEntity(create().getClass().getSimpleName()).getAllFields();

								for (Field f : fields)
								{
									if (f.getType() instanceof StringField || f.getType() instanceof TextField)
									{
										// lowercase the term and field so
										// matching becomes case insensitive
										// e.g. SELECT * FROM web WHERE
										// lower(metaDesc) LIKE
										// '%dscript%tutorial%'
										QueryRule searchQR = new QueryRule(f.getName(), Operator.LIKE, term.trim()
												.toLowerCase());
										searchQR.setField("lower(" + searchQR.getField() + ")");
										termRules.add(searchQR);
										termRules.add(new QueryRule(Operator.OR));
									}
								}

								// add as big X or Y or Z subquery to our rules
								searchRules.add(new QueryRule(termRules));

								if (addAND) searchRules.add(new QueryRule(Operator.AND));
								addAND = true;
							}

							where_clause.append("(");
							where_clause.append(createWhereSql(true, false,
									searchRules.toArray(new QueryRule[searchRules.size()])));
							where_clause.append(")");

						}
						catch (MolgenisModelException e)
						{
							throw new DatabaseException(e);
						}
					}
					else if (rule.getOperator() == QueryRule.Operator.NESTED)
					{
						QueryRule[] nestedrules = rule.getNestedRules();
						if (nestedrules.length > 0)
						{
							if (where_clause.length() > 0)
							{
								if (previousRule != null && Operator.OR.equals(previousRule.getOperator()))
								{
									where_clause.append(" OR ");
								}
								else
								{
									where_clause.append(" AND ");
								}
							}
							where_clause.append("(");
							where_clause.append(createWhereSql(true, false, nestedrules));
							where_clause.append(")");
						}
					}
					// experimental: subqery
					else if (rule.getOperator() == QueryRule.Operator.IN_SUBQUERY)
					{
						if (where_clause.length() > 0)
						{
							if (previousRule != null && Operator.OR.equals(previousRule.getOperator()))
							{
								where_clause.append(" OR ");
							}
							else
							{
								where_clause.append(" AND ");
							}
						}
						where_clause.append(rule.getField() + " IN(" + rule.getValue() + ")");
					}
					else if (rule.getOperator() == QueryRule.Operator.IN)
					{
						// only add if nonempty condition???
						if (rule.getValue() == null
								|| (rule.getValue() instanceof List<?> && ((List<?>) rule.getValue()).size() == 0)
								|| (rule.getValue() instanceof Object[] && ((Object[]) rule.getValue()).length == 0)) throw new DatabaseException(
								"empty 'in' clause for rule " + rule);
						{
							if (where_clause.length() > 0)
							{
								if (previousRule != null && Operator.OR.equals(previousRule.getOperator()))
								{
									where_clause.append(" OR ");
								}
								else
								{
									where_clause.append(" AND ");
								}
							}

							// where_clause.append(tablePrefix + rule.getField()
							// +
							// " IN(");
							where_clause.append(rule.getField() + " IN(");

							Object[] values = new Object[0];
							if (rule.getValue() instanceof List<?>)
							{
								values = ((List<?>) rule.getValue()).toArray();
							}
							else
							{
								values = (Object[]) rule.getValue();
							}

							for (int i = 0; i < values.length; i++)
							{
								if (i > 0) where_clause.append(",");
								if (omitQuotes(getFieldType(rule.getField())))
								{
									// where_clause.append(values[i]
									// .toString());
									where_clause.append("" + escapeSql(values[i]) + "");
								}
								else
								{
									where_clause.append("'" + escapeSql(values[i]) + "'");
								}
							}
							where_clause.append(") ");
						}
					}
					else
					// where clause
					{
						// check validity of the rule
						// if(rule.getField() == null ||
						// columnInfoMap.get(rule.getField()) == null )
						// {
						// throw new DatabaseException("Invalid rule: field '"+
						// rule.getField() + "' not known.");
						// }

						String operator = "";
						switch (rule.getOperator())
						{
							case EQUALS:
								operator = "=";
								break;
							case JOIN:
								operator = "=";
								break;
							case NOT:
								operator = "!=";
								break;
							case LIKE:
								operator = "LIKE";
								break;
							case LESS:
								operator = "<";
								break;
							case GREATER:
								operator = ">";
								break;
							case LESS_EQUAL:
								operator = "<=";
								break;
							case GREATER_EQUAL:
								operator = ">=";
								break;
						}
						// if (rule.getField() != "" && operator != "" &&
						// rule.getValue() != "")
						// {
						if (where_clause.length() > 0)
						{
							if (previousRule != null && Operator.OR.equals(previousRule.getOperator()))
							{
								where_clause.append(" OR ");
							}
							else
							{
								where_clause.append(" AND ");
							}
						}
						if (Boolean.TRUE.equals(rule.getValue())) rule.setValue("1");
						if (Boolean.FALSE.equals(rule.getValue())) rule.setValue("0");
						Object value = rule.getValue() == null ? "NULL" : escapeSql(rule.getValue());

						if (!value.equals("NULL") && rule.getOperator() == Operator.LIKE
								&& (!omitQuotes(getFieldType(rule.getField()))))
						{
							if (!value.toString().trim().startsWith("%") && !value.toString().trim().endsWith("%"))
							{
								value = "%" + value + "%";
							}
						}

						// if
						// (omitQuotes(columnInfoMap.get(rule.getField()).getType()))
						// where_clause.append(tablePrefix + rule.getField() +
						// " " +
						// operator + " " + value + "");
						// else
						// where_clause.append(tablePrefix + rule.getField() +
						// " " +
						// operator + " '" + value + "'");
						if (rule.getOperator().equals(Operator.JOIN))
						{
							where_clause.append(rule.getField() + " " + operator + " " + value + "");
						}
						else
						{
							if ("NULL".equals(value) && operator.equals("="))
							{
								where_clause.append(rule.getField() + " IS NULL");
							}
							else if ("NULL".equals(value) && operator.equals("!="))
							{
								where_clause.append(rule.getField() + " IS NOT NULL");
							}
							else
							{
								where_clause.append(rule.getField() + " " + operator + " '" + value + "'");
							}
						}
					}
					previousRule = null;
				}
			}
		}
		String result = where_clause.toString();
		if (!isNested && where_clause.length() > 0) result = " WHERE " + result;
		return result + createSortSql(false, rules) + createLimitSql(withOffset, rules);
	}

	/**
	 * Helper method for creating a limit clause
	 * 
	 * @param withOffset
	 *            Indicate whether offset is to be used. If false the limit
	 *            clause is kept empty.
	 * @param rules
	 *            query rules to be translated into sql order by clause.
	 * @return sql for limit,offset
	 */
	public static String createLimitSql(boolean withOffset, QueryRule[] rules)
	{
		String limit_clause = "";
		String offset_clause = "";
		if (rules != null)
		{
			for (QueryRule rule : rules)
			{
				// limit clause
				if (rule.getOperator() == QueryRule.Operator.LIMIT)
				{
					limit_clause = " LIMIT " + rule.getValue();
				}
				else if (rule.getOperator() == QueryRule.Operator.OFFSET)
				{
					offset_clause = " OFFSET " + rule.getValue();
				}
			}
		}
		if (withOffset || offset_clause.equals("")) return limit_clause + offset_clause;
		return "";
	}

	/**
	 * Helper method for creating a sort clause
	 * 
	 * @param mapper
	 *            mapper that is used to extract metadata to create the
	 * @param reverseSorting
	 *            to reverese sorting order. This is used when trying to find
	 *            the "last records" in a sorted list by instead finding the
	 *            "first records" in the reversly ordered list.
	 * @param rules
	 *            query rules to be translated into sql order by clause.
	 * @return sql with sort clause
	 */
	public String createSortSql(boolean reverseSorting, QueryRule rules[])
	{
		// copy parameter into local temp so we can change it
		StringBuilder sort_clauseBuilder = new StringBuilder();
		if (rules != null)
		{
			Boolean revSort = reverseSorting;
			for (QueryRule rule : rules)
			{
				if (rule.getOperator() == Operator.LAST)
				{
					revSort = !revSort;
					break;
				}
			}

			for (QueryRule r : rules)
			{
				QueryRule rule = new QueryRule(r); // copy because of
													// sideeffects

				// limit clause
				if ((rule.getOperator() == Operator.SORTASC && !revSort)
						|| (revSort && rule.getOperator() == Operator.SORTDESC))
				{
					rule.setValue(getTableFieldName(rule.getValue().toString()));
					sort_clauseBuilder.append(rule.getValue().toString()).append(" ASC,");
				}
				else if ((rule.getOperator() == QueryRule.Operator.SORTDESC && !revSort)
						|| (revSort && rule.getOperator() == Operator.SORTASC))
				{
					rule.setValue(getTableFieldName(rule.getValue().toString()));
					sort_clauseBuilder.append(rule.getValue().toString()).append(" DESC,");
				}
			}
		}
		if (sort_clauseBuilder.length() > 0) return " ORDER BY "
				+ sort_clauseBuilder.substring(0, sort_clauseBuilder.lastIndexOf(","));
		return sort_clauseBuilder.toString();
	}

	private static boolean omitQuotes(FieldType t)
	{
		return t instanceof LongField || t instanceof IntField || t instanceof DecimalField;

		// t.equals(Type.LONG) || t.equals(Type.INT) || t.equals(Type.DECIMAL);
		// return t instanceof LongField || t instanceof IntField|| t instanceof
		// DecimalField;

	}

	@Override
	public List<E> findByExample(E example) throws DatabaseException
	{
		Query<E> q = getDatabase().query(getDatabase().getEntityClass(example));
		// add first security rules
		// q.addRules(this.getLogin().getRowlevelSecurityFilters(example.getClass()));

		for (String field : example.getFields())
		{
			if (example.get(field) != null)
			{
				if (example.get(field) instanceof List<?>)
				{
					if (((List<?>) example.get(field)).size() > 0) q.in(field, (List<?>) example.get(field));
				}
				else
					q.equals(field, example.get(field));
			}
		}

		return q.find();
	}

	@Override
	public E findById(Object id) throws DatabaseException
	{
		List<E> result = find(new QueryRule(create().getIdField(), Operator.EQUALS, id));
		if (result.size() > 0) return result.get(0);
		return null;
	}
}
