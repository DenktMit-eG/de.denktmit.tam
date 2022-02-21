#!/bin/zsh
docker run \
--mount type=bind,source="$(pwd)",target=/home/schcrwlr \
--rm -it \
schemacrawler/schemacrawler \
/opt/schemacrawler/bin/schemacrawler.sh \
--server postgresql \
--host 172.17.0.3 \
--user dbuser \
--password supersecret \
--database application-db \
--info-level standard \
--command schema \
--output-file dbschema.png
