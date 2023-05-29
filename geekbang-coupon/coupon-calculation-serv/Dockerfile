FROM openjdk:8-jre

ADD ./coupon-calculation-impl/target/coupon-calculation-impl-1.0-SNAPSHOT.jar /app/coupon-calculation-serv.jar
CMD ["java", "-jar", "/app/coupon-calculation-serv.jar"]

RUN  echo "Asia/Shanghai" > /etc/timezone
RUN  dpkg-reconfigure -f noninteractive tzdata
