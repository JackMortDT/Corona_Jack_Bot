FROM gradle:4.7.0-jdk8-alpine AS build
COPY --chown=gradle:gradle . /jackbot/src
ADD --chown=gradle . /jackbot
WORKDIR /jackbot
RUN gradle build

FROM openjdk
WORKDIR /root/
ADD build/libs/jackbot-0.0.1.jar jackbot.jar
EXPOSE 8105
CMD java -jar jackbot.jar