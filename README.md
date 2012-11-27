# First try of mavenizing molgenis

This is a multi-module maven project

## modules:

* molgenis-maven-core contains molgenis/molgenis except the web res files (before in org.molgenis.framework.ui.res)
* molgenis-maven-webres contains the web res files in /src/main/webapp/res such as img, js, css
* molgenis-maven-omx contains the generated code from omicsconnect model
* molgenis-maven-portal is the 'war' that shows it all

## How to build

    checkout
    cd molgenis-maven
    mvn install
    cd molgenis-maven-portal
    mvn jetty:run

## Future module list

Generic:
* **molgenis-core**: consists of model + generator (jar)
* **molgenis-db**: the Entity, Tuple, TupleReader and Database interfaces and their implementations (jar)
* **molgenis-mvc**: the web user interface widgets and service framework (war? incl js,css,img)
* **molgenis-auth**: the security layer (or should this be part of db?)
* ...

Modules:
* **omx-core**: the generated code based on the data model
* ...

Apps:
* **omx-protocolview**: tree view of the catalogue of protocols and features
* **omx-importer**: import wizard for Excel and zip of tsv/csv
* **omx-dataview: viewer to select and filter data sets
* ...

Release:
* **omx-portal**: the release bundle that deploys all omx apps
* ...

NB: apps can be combined together in one release.

## Open discussions

1. We want to deal with multiple generated modules such as -omx

How to demo: we would like to implement them as small apps that could be assembled into a bigger one.

2. We want to NOT generate the UI but instead program it.

How to demo: we use factory methods?


