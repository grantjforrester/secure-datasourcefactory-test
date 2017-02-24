# Testing with Tomcat and Real Databases

# Build and Run a Postgres Database Service

The following docker commands create a new Docker container running a Postgres 9.6 database server initialised with contents of file [postgres/init.sql].
The database server will be available on the standard Postgres port '5432' with user name 'postgres' and password 'mysecretpassword'. 

1. Build a local Postgres Docker image with test schema & data:
	
	$ cd postgres
	$ docker build -t local/postgres .
	
2. Start a local Postgres Docker container:

	$ docker run --name some-postgres -d -p 5432:5432 local/postgres
 
3. [Optional] Verify database contents

	$ docker run -it --rm --link some-postgres:postgres -e PGPASSWORD=mysecretpassword postgres psql -h postgres -d test -U postgres

	PSQL> select * from greeting;


# Build and Run an Oracle Database Service

The following docker commands create a new Docker container running an Oracle 12c database server initialised with contents of file [oracle/init.sql].
The database server will be available on the standard Oracle port '1521' with user name 'test' and password 'mysecretpassword'. 

1. Build a local Oracle Docker image with test schema & data:
	
	$ cd oracle
	$ docker build -t local/oracle .
	
2. Start a local Oracle Docker container

	$ docker run --name some-oracle -d -p 8080:8080 -p 1521:1521 local/oracle
	
!! THE FIRST RUN OF THE CONTAINER CAN TAKE A WHILE. LIKE 5 MINUTES !! You can follow progress with ``$ docker logs -f some-oracle``
I had to increase the Docker VM memory for this to work.  I chose 2096MB.

3. [Optional] Verify database contents

	$ docker run -it --rm --link some-oracle:oracle -e URL=test/mysecretpassword@//oracle:1521/xe.oracle.docker sflyr/sqlplus

	SQL> select * from greeting;

	
References: [Docker run](https://docs.docker.com/engine/reference/run/)
