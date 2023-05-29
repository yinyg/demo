#!/bin/bash

docker-compose -f docker-compose-application.yml down

docker-compose -f docker-compose-nacos.yml down

docker image rm geekbang-coupon-coupon-template-serv geekbang-coupon-coupon-calculation-serv geekbang-coupon-coupon-customer-serv
