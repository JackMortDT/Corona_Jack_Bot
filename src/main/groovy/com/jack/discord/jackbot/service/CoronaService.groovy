package com.jack.discord.jackbot.service

import com.jack.discord.jackbot.command.CountriesResponse
import com.jack.discord.jackbot.command.StatisticsResponse
import org.springframework.http.HttpHeaders

interface CoronaService {

  CountriesResponse getAllCountries()
  StatisticsResponse getStatisticsForCountry(String countryName)
  HttpHeaders getHeaders()

}