@echo off
call mvn clean package
call docker build -t com.mycompany/hello .
call docker rm -f hello
call docker run -d -p 9080:9080 -p 9443:9443 --name hello com.mycompany/hello