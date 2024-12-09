# Jakarta Project

## Setup

### Create Docker Images

- Postgres:
`docker build --tag <db_image_name> --target postgres .`
- Application:
`docker build --tag <appl_image_name> --target java .`

### Run Docker Containers

- Postgres:
`docker run --name <db_image_name> -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d <db_image_name>`
- Application:
`docker run -it -p 8080:8080 --rm <appl_image_name>`