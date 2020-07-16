package com.jack.discord.jackbot.service.impl

import com.jack.discord.jackbot.command.CountriesResponse
import com.jack.discord.jackbot.command.StatisticsResponse
import com.jack.discord.jackbot.service.CoronaService
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

import javax.annotation.PostConstruct

import static org.springframework.http.MediaType.APPLICATION_JSON

@Service
class CoronaServiceImpl implements CoronaService{

  @Value('${x.rapidapi.key}')
  String apiKey
  @Value('${x.rapidapi.host}')
  String host

  @Override
  @PostConstruct
  CountriesResponse getAllCountries(){
      RestTemplate restTemplate = new RestTemplate()
      String url = "${host}/countries"
      HttpEntity<String> entity = new HttpEntity<String>("parameters", getHeaders())
      ResponseEntity<CountriesResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, CountriesResponse)
      response.body
  }

  @Override
  StatisticsResponse getStatisticsForCountry(String countryName) {
    RestTemplate restTemplate = new RestTemplate()
    String url = "${host}/statistics?country={country}"
    HttpEntity<String> entity = new HttpEntity<String>("parameters", getHeaders())
    ResponseEntity<StatisticsResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, StatisticsResponse, countryName)
    response.body
  }

  @Override
  HttpHeaders getHeaders() {
    HttpHeaders headers = new HttpHeaders()
    headers.setContentType(APPLICATION_JSON)
    headers.add('x-rapidapi-key', apiKey)
    headers
  }

}
