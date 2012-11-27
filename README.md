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

## Open discussions

1. We want to deal with multiple generated modules such as -omx

How to demo: we would like to implement them as small apps that could be assembled into a bigger one.

2. We want to NOT generate the UI but instead program it.

How to demo: we use factory methods?


