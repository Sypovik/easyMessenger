#!/bin/bash

source .env

if [ "$1" == "start" ]; then
    echo "Starting server"
    docker-compose up --build -d
    docker exec -it "$NAME_APP_CONTAINER" mvn spring-boot:run
elif [ "$1" == "start_mvn" ]; then
    docker exec -it "$NAME_APP_CONTAINER" mvn spring-boot:run
elif [ "$1" == "restart" ]; then
    echo "Restarting server"
    docker-compose restart -d
    docker exec -it "$NAME_APP_CONTAINER" mvn spring-boot:run

elif [ "$1" == "inputServer" ]; then
    echo "Input data"
    docker exec -it "$NAME_APP_CONTAINER" /bin/bash

elif [ "$1" == "inputDB" ]; then
    echo "Input data"
    docker exec -it "$NAME_DB_CONTAINER"  psql -U postgres -d $NAME_DB_CONTAINER

elif [ "$1" == "client" ]; then
    echo "Starting client"
    cd src/main/resources/static && python3 -m http.server $PORT_CLIENT
    
elif [ "$1" == "clean" ]; then
    echo "Stopping server"
    docker-compose -v down
fi

