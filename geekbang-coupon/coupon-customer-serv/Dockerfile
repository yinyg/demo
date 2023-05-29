FROM openjdk:8-jre

ADD ./coupon-customer-impl/target/coupon-customer-impl-1.0-SNAPSHOT.jar /app/coupon-customer-serv.jar
CMD ["java", "-jar", "/app/coupon-customer-serv.jar"]

RUN  echo "Asia/Shanghai" > /etc/timezone
RUN  dpkg-reconfigure -f noninteractive tzdata
