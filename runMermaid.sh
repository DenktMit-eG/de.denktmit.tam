#!/bin/zsh
dockerContainer=$(docker ps --format '{{.ID}}' --filter 'name=tam-develop-pg')
containerIp=$(docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' $dockerContainer)
echo "pg-container:" $dockerContainer " ip:" $containerIp
docker run \
--mount type=bind,source="$(pwd)",target=/home/schcrwlr \
--rm -it \
schemacrawler/schemacrawler \
/opt/schemacrawler/bin/schemacrawler.sh \
--server postgresql \
--host $containerIp \
--user dbuser \
--password supersecret \
--database application-db \
--info-level standard \
--command schema \
--output-file dbschema.png
