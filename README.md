Secure Tomcat DataSourceFactory Test
====================================

The purpose of this project is to test the secure Tomcat datasource. The Maven project builds a very simple WAR file with a single servlet available at ``/secure-datasourcefactory-test/hello``.  The servlet expects a JNDI datasource ``jdbc/mydatabase``. The JNDI datasource is defined in the file [/src/main/webapp/META-INF/context.xml](src/main/webapp/META-INF/context.xml). This file contains a number of example configurations.

The servlet expects the connected database to contain a table named GREETING with the following content:

| ID | HELLO               |
|----|---------------------|
| 0  | Hello from database | 


Docker
------

The folder [/docker](docker) contains a number of Docker files for creating different database containers pre-populated with the required data.  See [/docker/README.md](docker/README.md) fro details on how to build and run the containers. Currently available containers:

* Postgres 9.6
* Oracle 12c