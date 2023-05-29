FROM openjdk:8-jre

ADD ./coupon-template-impl/target/coupon-template-impl-1.0-SNAPSHOT.jar /app/coupon-template-serv.jar
CMD ["java", "-jar", "/app/coupon-template-serv.jar"]

RUN  echo "Asia/Shanghai" > /etc/timezone
RUN  dpkg-reconfigure -f noninteractive tzdata
