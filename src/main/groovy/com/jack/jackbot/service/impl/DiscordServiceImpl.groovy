package com.jack.jackbot.service.impl

import com.jack.jackbot.command.CountriesResponse
import com.jack.jackbot.command.StatisticsResponse
import com.jack.jackbot.service.CoronaService
import com.jack.jackbot.service.DiscordService
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DiscordServiceImpl implements DiscordService{

  @Autowired
  CoronaService coronaService

  @Override
  void discordMenu(MessageReceivedEvent event) {
    String content = event.message.contentDisplay
    switch (content) {
      case ~/!help/: help(event)
        break
      case ~/!statistics\s.*/: fetchStatistics(event)
        break
    }
  }

  @Override
  void help(MessageReceivedEvent event) {
    event.channel.sendMessage("!Hi type **!statistics** CountryName for information by country").queue()
  }

  @Override
  void fetchStatistics(MessageReceivedEvent event) {
    String message = event.message.contentDisplay
    List<String> splitMessage = message.split("\\s+")
    CountriesResponse countriesList = coronaService.getAllCountries()
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
  }

}
