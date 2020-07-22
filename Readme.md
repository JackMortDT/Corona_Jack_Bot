# Corona JackBot

Multiplatform bot (Slack, Discord), made using Spring Boot, Written for fun.

## Services
| Type                          | Badges                    |
|-------------------------------|---------------------------|
| **Continuous Integration:**  | [![travis-icon]][travis]  |


## Configuration

```properties
spring.output.ansi.enabled=ALWAYS

# Bots
discord.bot.token=${DISCORD_TOKEN}
slackBotToken=${SLACK_TOKEN}
rtmUrl=https://slack.com/api/rtm.start?token=${slackBotToken}&simple_latest&no_unreads

# Rapidapi
x.rapidapi.key=${RAPIDAPI_TOKEN}
x.rapidapi.host=https://covid-193.p.rapidapi.com

jib.to.image='jackmortdt/jackbot'
```

## License
See the [License][license] file.

[travis-icon]: https://travis-ci.org/JackMortDT/Corona_Jack_Bot.svg?branch=master
[travis]: https://travis-ci.org/JackMortDT/Corona_Jack_Bot
[license]: https://github.com/JackMortDT/Corona_Jack_Bot/blob/master/LICENSE