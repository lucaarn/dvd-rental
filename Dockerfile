FROM postgres:12.4 as postgres
RUN localedef -i de_DE -c -f UTF-8 -A /usr/share/locale/locale.alias de_DE.UTF-8
ENV LANG de_DE.utf-8
COPY ./create.sql /docker-entrypoint-initdb.d

FROM eclipse-temurin:23 as java
COPY ./target/dvd-rental-1.0-runner.jar /home
WORKDIR /home
CMD ["java", "-jar", "dvd-rental-1.0-runner.jar"]