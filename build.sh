#!/bin/bash

# db
docker run --name vera-postgres -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres

sleep 10

# init db
docker exec -it vera-postgres mkdir /sql
docker cp ./docs/init/init.sql vera-postgres:/sql/
docker exec -u postgres vera-postgres psql postgres postgres -f /sql/init.sql

# build backend
docker build --tag hanomi/vera-otus-highload-d1 .
# run it!
docker run --name vera-backend --add-host=host.docker.internal:host-gateway -e spring_datasource_url=jdbc:postgresql://host.docker.internal:5432/postgres -p 8080:8080 -d hanomi/vera-otus-highload-d1