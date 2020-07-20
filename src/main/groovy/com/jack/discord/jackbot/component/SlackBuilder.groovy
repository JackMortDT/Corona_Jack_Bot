package com.jack.discord.jackbot.component

import com.jack.discord.jackbot.command.CountriesResponse
import com.jack.discord.jackbot.command.StatisticsResponse
import com.jack.discord.jackbot.service.CoronaService
import me.ramswaroop.jbot.core.slack.Bot
import me.ramswaroop.jbot.core.slack.Controller
import me.ramswaroop.jbot.core.slack.EventType
import me.ramswaroop.jbot.core.slack.models.Event
import me.ramswaroop.jbot.core.slack.models.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.socket.WebSocketSession

import java.util.regex.Matcher

@Component
class SlackBuilder extends Bot {

  @Value('${slackBotToken}')
  String slackToken

  @Autowired
  CoronaService coronaService

  @Override
  String getSlackToken() {
    slackToken
  }

  @Override
  Bot getSlackBot() {
    return this
  }

  @Controller(events = [EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE])
  void onReceiveDM(WebSocketSession session, Event event) {
    String message = event.text
    switch (message) {
      case ~/hello/: hello(session, event)
        break
      case ~/help/: help(session, event)
        break
      case ~/statistics\s.*/: fetchStatistics(session, event)
        break
    }
  }

  @Controller(events = EventType.MESSAGE, pattern = "hi|hello|hola")
  void onReceiveMessage(WebSocketSession session, Event event, Matcher matcher) {
    if (!matcher.group(0).isEmpty()) {
      reply(session, event, new Message("Hi!! ${slackService.currentUser.name}"))
    }
  }

  void hello(WebSocketSession session, Event event) {
    reply(session, event, new Message("Hi, I am ${slackService.currentUser.name}"))
  }

  void help(WebSocketSession session, Event event) {
    reply(session, event, new Message("!Hi type **statistics** CountryName for information by country"))
  }

  void fetchStatistics(WebSocketSession session, Event event) {
    String message = event.text
    List<String> splitMessage = message.split("\\s+")
    CountriesResponse countriesList = coronaService.getAllCountries()
    String validatedCountry = countriesList.response.find(){ countryBank ->
      countryBank == splitMessage[1]
    }
    if(validatedCountry){
      StatisticsResponse stats = coronaService.getStatisticsForCountry(validatedCountry)
      reply(session, event, new Message("${stats.countriesList[0].toString()}"))
    } else {
      reply(session, event, new Message("Country did not match with availables countries, try one of these"))
      reply(session, event, new Message("${countriesList.response.join(', ').take(1000)}..."))
    }
  }

}
