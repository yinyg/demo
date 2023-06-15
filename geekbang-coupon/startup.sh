#!/bin/bash

# 先启动nacos，等待60秒，然后再构建启动应用，防止应用启动时，nacos还没有完成启动
docker-compose -f docker-compose-nacos.yml up -d

sleep 60s

mvn clean package -Dmaven.test.skip=true

docker-compose -f docker-compose-application.yml up -d
