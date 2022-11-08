FROM maven:3.6.3 as build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN mvn clean install -DskipTests=true

FROM openjdk:11
COPY --from=build /usr/app/target/*.jar /app/spring-batch.jar
EXPOSE 9999
ENTRYPOINT java -jar /app/spring-batch.jar