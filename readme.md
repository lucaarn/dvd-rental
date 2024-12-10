# Jakarta Project

## Setup

### Generate jar

`mvn package -Dquarkus.package.jar.type=uber-jar`

### Create Docker Images

- Postgres:
`docker build --tag ftse-dvd-rental-customer --target postgres .`
- Application:
`docker build --tag ftse-quarkus-jar --target java .`

### Run Docker Containers

- Postgres:
`docker run --name ftse-dvd-rental-customer -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d ftse-dvd-rental-customer`
- Application:
`docker run -it -p 8080:8080 --rm ftse-quarkus-jar`