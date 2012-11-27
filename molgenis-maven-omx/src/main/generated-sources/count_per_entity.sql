SELECT 'MolgenisEntity' AS entity, count(*) AS count FROM MolgenisEntity
 UNION 
SELECT 'MolgenisFile' AS entity, count(*) AS count FROM MolgenisFile
 UNION 
SELECT 'RuntimeProperty' AS entity, count(*) AS count FROM RuntimeProperty
 UNION 
SELECT 'MolgenisRole' AS entity, count(*) AS count FROM MolgenisRole WHERE __Type = 'MolgenisRole'
 UNION 
SELECT 'MolgenisGroup' AS entity, count(*) AS count FROM MolgenisRole NATURAL JOIN MolgenisGroup WHERE __Type = 'MolgenisGroup'
 UNION 
SELECT 'MolgenisUser' AS entity, count(*) AS count FROM MolgenisUser
 UNION 
SELECT 'MolgenisRoleGroupLink' AS entity, count(*) AS count FROM MolgenisRoleGroupLink
 UNION 
SELECT 'MolgenisPermission' AS entity, count(*) AS count FROM MolgenisPermission
 UNION 
SELECT 'Characteristic' AS entity, count(*) AS count FROM Characteristic WHERE __Type = 'Characteristic'
 UNION 
SELECT 'ObservationTarget' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN ObservationTarget WHERE __Type = 'ObservationTarget'
 UNION 
SELECT 'ObservableFeature' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN ObservableFeature WHERE __Type = 'ObservableFeature'
 UNION 
SELECT 'Category' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN Category WHERE __Type = 'Category'
 UNION 
SELECT 'Protocol' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN Protocol WHERE __Type = 'Protocol'
 UNION 
SELECT 'DataSet' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN DataSet WHERE __Type = 'DataSet'
 UNION 
SELECT 'ObservationSet' AS entity, count(*) AS count FROM ObservationSet
 UNION 
SELECT 'ObservedValue' AS entity, count(*) AS count FROM ObservedValue WHERE __Type = 'ObservedValue'
 UNION 
SELECT 'Species' AS entity, count(*) AS count FROM OntologyTerm NATURAL JOIN Species WHERE __Type = 'Species'
 UNION 
SELECT 'Individual' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN ObservationTarget NATURAL JOIN Individual WHERE __Type = 'Individual'
 UNION 
SELECT 'Panel' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN ObservationTarget NATURAL JOIN Panel WHERE __Type = 'Panel'
 UNION 
SELECT 'PanelSource' AS entity, count(*) AS count FROM PanelSource
 UNION 
SELECT 'Ontology' AS entity, count(*) AS count FROM Ontology
 UNION 
SELECT 'OntologyTerm' AS entity, count(*) AS count FROM OntologyTerm WHERE __Type = 'OntologyTerm'
 UNION 
SELECT 'Accession' AS entity, count(*) AS count FROM OntologyTerm NATURAL JOIN Accession WHERE __Type = 'Accession'
 UNION 
SELECT 'Genome' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN Genome WHERE __Type = 'Genome'
 UNION 
SELECT 'Chromosome' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN Chromosome WHERE __Type = 'Chromosome'
 UNION 
SELECT 'Gene' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN Gene WHERE __Type = 'Gene'
 UNION 
SELECT 'Protein' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN Protein WHERE __Type = 'Protein'
 UNION 
SELECT 'ProteinDomain' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN ProteinDomain WHERE __Type = 'ProteinDomain'
 UNION 
SELECT 'Exon' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN Exon WHERE __Type = 'Exon'
 UNION 
SELECT 'Variant' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN Variant WHERE __Type = 'Variant'
 UNION 
SELECT 'Study' AS entity, count(*) AS count FROM Study
 UNION 
SELECT 'Experiment' AS entity, count(*) AS count FROM Experiment WHERE __Type = 'Experiment'
 UNION 
SELECT 'Institute' AS entity, count(*) AS count FROM Institute
 UNION 
SELECT 'Person' AS entity, count(*) AS count FROM Person
 UNION 
SELECT 'Citation' AS entity, count(*) AS count FROM Citation
 UNION 
SELECT 'Contribution' AS entity, count(*) AS count FROM Contribution
 UNION 
SELECT 'Submission' AS entity, count(*) AS count FROM Submission
 UNION 
SELECT 'Investigation' AS entity, count(*) AS count FROM Investigation
 UNION 
SELECT 'StudyDetails' AS entity, count(*) AS count FROM StudyDetails
 UNION 
SELECT 'FrequencyCluster' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN DataSet NATURAL JOIN FrequencyCluster WHERE __Type = 'FrequencyCluster'
 UNION 
SELECT 'GenotypeFrequency' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN DataSet NATURAL JOIN GenotypeFrequency WHERE __Type = 'GenotypeFrequency'
 UNION 
SELECT 'AlleleFrequency' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN DataSet NATURAL JOIN AlleleFrequency WHERE __Type = 'AlleleFrequency'
 UNION 
SELECT 'PhenotypeProperty' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN ObservableFeature NATURAL JOIN PhenotypeProperty WHERE __Type = 'PhenotypeProperty'
 UNION 
SELECT 'PhenotypeMethod' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN DataSet NATURAL JOIN PhenotypeMethod WHERE __Type = 'PhenotypeMethod'
 UNION 
SELECT 'PhenotypeValue' AS entity, count(*) AS count FROM ObservedValue NATURAL JOIN PhenotypeValue WHERE __Type = 'PhenotypeValue'
 UNION 
SELECT 'SamplePanel' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN ObservationTarget NATURAL JOIN Panel NATURAL JOIN SamplePanel WHERE __Type = 'SamplePanel'
 UNION 
SELECT 'AssayedPanel' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN ObservationTarget NATURAL JOIN Panel NATURAL JOIN AssayedPanel WHERE __Type = 'AssayedPanel'
 UNION 
SELECT 'GWASExperiment' AS entity, count(*) AS count FROM Experiment NATURAL JOIN GWASExperiment WHERE __Type = 'GWASExperiment'
 UNION 
SELECT 'UsedMarkerSet' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN ObservableFeature NATURAL JOIN UsedMarkerSet WHERE __Type = 'UsedMarkerSet'
 UNION 
SELECT 'Significance' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN DataSet NATURAL JOIN Significance WHERE __Type = 'Significance'
 UNION 
SELECT 'EffectSize' AS entity, count(*) AS count FROM Characteristic NATURAL JOIN DataSet NATURAL JOIN EffectSize WHERE __Type = 'EffectSize'
 UNION 
SELECT 'SelectionCriteria' AS entity, count(*) AS count FROM SelectionCriteria
 UNION 
SELECT 'Protocol_subprotocols' AS entity, count(*) AS count FROM Protocol_subprotocols
 UNION 
SELECT 'Protocol_Features' AS entity, count(*) AS count FROM Protocol_Features
 UNION 
SELECT 'Panel_Individuals' AS entity, count(*) AS count FROM Panel_Individuals
 UNION 
SELECT 'Experiment_AssayedPanels' AS entity, count(*) AS count FROM Experiment_AssayedPanels
 UNION 
SELECT 'Experiment_DataSets' AS entity, count(*) AS count FROM Experiment_DataSets
 UNION 
SELECT 'Person_AffiliateInstitutions' AS entity, count(*) AS count FROM Person_AffiliateInstitutions
 UNION 
SELECT 'Citation_ontologyTerms' AS entity, count(*) AS count FROM Citation_ontologyTerms
 UNION 
SELECT 'StudyDetails_otherCitations' AS entity, count(*) AS count FROM StudyDetails_otherCitations

;