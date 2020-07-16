package com.jack.discord.jackbot.service

import com.jack.discord.jackbot.command.CountriesResponse
import org.springframework.http.HttpHeaders

interface CoronaService {

  CountriesResponse getAllCountries()
  void getStatisticsForCountry(String countryName)
  HttpHeaders getHeaders()

}