package com.jack.jackbot.service

import com.jack.jackbot.command.CountriesResponse
import com.jack.jackbot.command.StatisticsResponse
import org.springframework.http.HttpHeaders

interface CoronaService {

  CountriesResponse getAllCountries()

  StatisticsResponse getStatisticsForCountry(String countryName)
  HttpHeaders getHeaders()

}