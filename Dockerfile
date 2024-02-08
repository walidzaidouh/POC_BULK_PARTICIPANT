FROM openjdk:8-jdk-alpine

# chemin par defaut du jar
ARG JAR_FILE=switch/VIRM_MASS_BANK-0.0.1-SNAPSHOT.jar
# chemin par defaut de la config
ARG CONFIG_FILE=application.yml

# cd /opt/app
WORKDIR /opt/app

# cp target/simulator-0.0.1.jar /opt/app/simulator.jar
ADD ${JAR_FILE} VIRM_MASS_BANK.jar

ADD ${CONFIG_FILE} application.yml

# java -jar /opt/app/simulator.jar
ENTRYPOINT exec java -jar /opt/app/VIRM_MASS_BANK.jar --spring.config.location=/opt/app/application.properties

EXPOSE 8080

# Pour builder l'image en passant le chemin du jar et le chemin du fichier de config :
#   Command
#      docker build -t simulator:1.0 --build-arg JAR_FILE=./simulator-0.0.1.jar --build-arg CONFIG_FILE=./application.properties  .


# Pour lancer le conteneur :
#  docker run -p 8080:8080 -t simulator:1.0






## sudo docker run -p 8080:8080 -t docker-spring-boot:1.0
## sudo docker run -p 80:8080 -t docker-spring-boot:1.0
## sudo docker run -p 443:8443 -t docker-spring-boot:1.0