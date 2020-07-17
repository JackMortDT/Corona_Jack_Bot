package com.jack.discord.jackbot.listener

import com.jack.discord.jackbot.command.CountriesResponse
import com.jack.discord.jackbot.command.StatisticsResponse
import com.jack.discord.jackbot.service.CoronaService
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CoronaListener extends ListenerAdapter{

  @Autowired
  CoronaService coronaService

  @Override
  void onMessageReceived(MessageReceivedEvent event) {
    if(event.message.author.isBot()) return
    String content = event.message.contentDisplay
    switch (content) {
      case ~/!help/: help(event)
        break
      case ~/!statistics\s.*/: fetchStatistics(event)
        break
    }
  }

  static void help(MessageReceivedEvent event) {
    println event.author
    println event.author
    event.channel.sendMessage("!Hi type **!statistics** CountryName for information by country").queue()
  }

  void fetchStatistics(MessageReceivedEvent event) {
    String message = event.message.contentDisplay
    List<String> splitMessage = message.split("\\s+")
    CountriesResponse countriesList = coronaService.getAllCountries()
    if(splitMessage[1]){
      String validatedCountry = countriesList.response.find(){ countryBank ->
        countryBank == splitMessage[1]
      }
      if(validatedCountry){
        StatisticsResponse stats = coronaService.getStatisticsForCountry(validatedCountry)
        event.channel.sendMessageFormat("${stats.countriesList[0].toString()} \n").queue()
      } else {
        event.channel.sendMessage("Country did not match with availables countries, try one of these").queue()
        event.channel.sendMessageFormat("${countriesList.response.join(', ').take(1000)}...").queue()
      }
    } else {
      event.channel.sendMessage("Country did not match with availables countries, try one of these").queue()
    }
  }

}
