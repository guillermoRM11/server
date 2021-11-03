#!/bin/sh
mvn clean package && docker build -t com.mycompany/hello .
docker rm -f hello || true && docker run -d -p 9080:9080 -p 9443:9443 --name hello com.mycompany/hello