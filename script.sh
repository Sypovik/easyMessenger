#!/bin/bash

source .env

if [ $1 == "start" ]; then
    echo "Starting server"
    docker-compose down
    docker-compose up --build -d
    docker exec -it "$NAME_APP_CONTAINER" mvn spring-boot:run

elif [ $1 == "input" ]; then
    echo "Input data"
    docker-compose run --rm $NAME_APP_CONTAINER /bin/bash
fi