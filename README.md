Secure Tomcat DataSourceFactory Test
====================================

The purpose of this project is to test the [secure Tomcat datasourcefactory](https://github.com/ncredinburgh/secure-tomcat-datasourcefactory). The Maven project builds a very simple WAR file with a single servlet available at ``/secure-datasourcefactory-test/hello``.  The servlet expects a JNDI datasource ``jdbc/mydatabase``. The JNDI datasource is defined in the file [/src/main/webapp/META-INF/context.xml](src/main/webapp/META-INF/context.xml). This file contains a number of example configurations.

The servlet expects the connected database to contain a table named GREETING with the following content:

| ID | HELLO               |
|----|---------------------|
| 0  | Hello from database | 


Docker
------

The folder [/docker](docker) contains a number of Docker files for creating different database containers pre-populated with the required data.  See [/docker/README.md](docker/README.md) for details on how to build and run the containers. Currently available containers:

* Postgres 9.6
* Oracle 12c


Test Tools
----------

You can test the sample application and configuration using the Apache benchmarking tool [ab](https://httpd.apache.org/docs/2.4/programs/ab.html). For example,

    $ ab -n 100000 -c 20 http://localhost:8080/secure-datasourcefactory-test/hello
    
would send 100000 requests to the application running on `localhost` (and on to the database) with a currency of 20 clients. 