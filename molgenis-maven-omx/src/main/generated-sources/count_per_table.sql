SELECT 'MolgenisEntity' AS entity, count(*) AS count FROM molgenisEntity
 UNION 
SELECT 'MolgenisFile' AS entity, count(*) AS count FROM molgenisFile
 UNION 
SELECT 'RuntimeProperty' AS entity, count(*) AS count FROM runtimeProperty
 UNION 
SELECT 'MolgenisRole' AS entity, count(*) AS count FROM molgenisRole
 UNION 
SELECT 'MolgenisGroup' AS entity, count(*) AS count FROM molgenisGroup
 UNION 
SELECT 'MolgenisUser' AS entity, count(*) AS count FROM molgenisUser
 UNION 
SELECT 'MolgenisRoleGroupLink' AS entity, count(*) AS count FROM molgenisRoleGroupLink
 UNION 
SELECT 'MolgenisPermission' AS entity, count(*) AS count FROM molgenisPermission
 UNION 
SELECT 'Characteristic' AS entity, count(*) AS count FROM characteristic
 UNION 
SELECT 'ObservationTarget' AS entity, count(*) AS count FROM observationTarget
 UNION 
SELECT 'ObservableFeature' AS entity, count(*) AS count FROM observableFeature
 UNION 
SELECT 'Category' AS entity, count(*) AS count FROM category
 UNION 
SELECT 'Protocol' AS entity, count(*) AS count FROM protocol
 UNION 
SELECT 'DataSet' AS entity, count(*) AS count FROM dataSet
 UNION 
SELECT 'ObservationSet' AS entity, count(*) AS count FROM observationSet
 UNION 
SELECT 'ObservedValue' AS entity, count(*) AS count FROM observedValue
 UNION 
SELECT 'Species' AS entity, count(*) AS count FROM species
 UNION 
SELECT 'Individual' AS entity, count(*) AS count FROM individual
 UNION 
SELECT 'Panel' AS entity, count(*) AS count FROM panel
 UNION 
SELECT 'PanelSource' AS entity, count(*) AS count FROM panelSource
 UNION 
SELECT 'Ontology' AS entity, count(*) AS count FROM ontology
 UNION 
SELECT 'OntologyTerm' AS entity, count(*) AS count FROM ontologyTerm
 UNION 
SELECT 'Accession' AS entity, count(*) AS count FROM accession
 UNION 
SELECT 'Genome' AS entity, count(*) AS count FROM genome
 UNION 
SELECT 'Chromosome' AS entity, count(*) AS count FROM chromosome
 UNION 
SELECT 'Gene' AS entity, count(*) AS count FROM gene
 UNION 
SELECT 'Protein' AS entity, count(*) AS count FROM protein
 UNION 
SELECT 'ProteinDomain' AS entity, count(*) AS count FROM proteinDomain
 UNION 
SELECT 'Exon' AS entity, count(*) AS count FROM exon
 UNION 
SELECT 'Variant' AS entity, count(*) AS count FROM variant
 UNION 
SELECT 'Study' AS entity, count(*) AS count FROM study
 UNION 
SELECT 'Experiment' AS entity, count(*) AS count FROM experiment
 UNION 
SELECT 'Institute' AS entity, count(*) AS count FROM institute
 UNION 
SELECT 'Person' AS entity, count(*) AS count FROM person
 UNION 
SELECT 'Citation' AS entity, count(*) AS count FROM citation
 UNION 
SELECT 'Contribution' AS entity, count(*) AS count FROM contribution
 UNION 
SELECT 'Submission' AS entity, count(*) AS count FROM submission
 UNION 
SELECT 'Investigation' AS entity, count(*) AS count FROM investigation
 UNION 
SELECT 'StudyDetails' AS entity, count(*) AS count FROM studyDetails
 UNION 
SELECT 'FrequencyCluster' AS entity, count(*) AS count FROM frequencyCluster
 UNION 
SELECT 'GenotypeFrequency' AS entity, count(*) AS count FROM genotypeFrequency
 UNION 
SELECT 'AlleleFrequency' AS entity, count(*) AS count FROM alleleFrequency
 UNION 
SELECT 'PhenotypeProperty' AS entity, count(*) AS count FROM phenotypeProperty
 UNION 
SELECT 'PhenotypeMethod' AS entity, count(*) AS count FROM phenotypeMethod
 UNION 
SELECT 'PhenotypeValue' AS entity, count(*) AS count FROM phenotypeValue
 UNION 
SELECT 'SamplePanel' AS entity, count(*) AS count FROM samplePanel
 UNION 
SELECT 'AssayedPanel' AS entity, count(*) AS count FROM assayedPanel
 UNION 
SELECT 'GWASExperiment' AS entity, count(*) AS count FROM gWASExperiment
 UNION 
SELECT 'UsedMarkerSet' AS entity, count(*) AS count FROM usedMarkerSet
 UNION 
SELECT 'Significance' AS entity, count(*) AS count FROM significance
 UNION 
SELECT 'EffectSize' AS entity, count(*) AS count FROM effectSize
 UNION 
SELECT 'SelectionCriteria' AS entity, count(*) AS count FROM selectionCriteria
 UNION 
SELECT 'Protocol_subprotocols' AS entity, count(*) AS count FROM protocol_subprotocols
 UNION 
SELECT 'Protocol_Features' AS entity, count(*) AS count FROM protocol_Features
 UNION 
SELECT 'Panel_Individuals' AS entity, count(*) AS count FROM panel_Individuals
 UNION 
SELECT 'Experiment_AssayedPanels' AS entity, count(*) AS count FROM experiment_AssayedPanels
 UNION 
SELECT 'Experiment_DataSets' AS entity, count(*) AS count FROM experiment_DataSets
 UNION 
SELECT 'Person_AffiliateInstitutions' AS entity, count(*) AS count FROM person_AffiliateInstitutions
 UNION 
SELECT 'Citation_ontologyTerms' AS entity, count(*) AS count FROM citation_ontologyTerms
 UNION 
SELECT 'StudyDetails_otherCitations' AS entity, count(*) AS count FROM studyDetails_otherCitations

;