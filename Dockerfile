FROM openjdk
WORKDIR /root/
ADD build/libs/jackbot-0.0.1.jar jackbot.jar
EXPOSE 8105
CMD java -jar jackbot.jar