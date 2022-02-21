# de.denktmit.tam

Web application to process time and material records

## Start hacking
    docker-compose up -d

## Autogenerate DB Schema

./runMermaid.sh
Runs SchemaCrawler in Docker against IP 172.17.0.3, with some luck that's your TEST application-db Docker container. Automatically updates dbschema.png.

Smart solution welcome.

![image info](./dbschema.png)
