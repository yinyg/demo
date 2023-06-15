FROM openjdk:8-jre

ADD ./sentinel-dashboard-1.8.2.jar /app/sentinel-dashboard-1.8.2.jar
CMD ["java", "-Dserver.port=8080", "-Dcsp.sentinel.dashboard.server=localhost:8080", "-Dproject.name=sentinel-dashboard", "-jar", "/app/sentinel-dashboard-1.8.2.jar"]

RUN  echo "Asia/Shanghai" > /etc/timezone
RUN  dpkg-reconfigure -f noninteractive tzdata
