# Jakarta Project

## Setup

### Generate jar

`mvn package -Dquarkus.package.jar.type=uber-jar`

### Create Images

- Postgres:
  `podman build --tag ftse-dvd-rental-customer --target postgres .`
- Application:
  `podman build --tag ftse-quarkus-jar --target java .`

### Create Network

`podman network create dvd-rental`

### Run Containers

- Postgres:
  `podman run --name ftse-dvd-rental-customer -e POSTGRES_PASSWORD=postgres -p 5432:5432 --network=dvd-rental -d ftse-dvd-rental-customer`
- Application:
  `podman run -it -p 8080:8080 --network=dvd-rental --rm ftse-quarkus-jar`