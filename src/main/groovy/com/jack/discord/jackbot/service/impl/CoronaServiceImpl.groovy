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

  CountriesResponse availableCountries

  @Override
  @PostConstruct
  CountriesResponse getAllCountries(){
    if(availableCountries == null) {
      RestTemplate restTemplate = new RestTemplate()
      String url = "https://covid-193.p.rapidapi.com/countries"
      HttpEntity<String> entity = new HttpEntity<String>("parameters", getHeaders())
      ResponseEntity<CountriesResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, CountriesResponse)
      availableCountries=response.body
    } else {
      availableCountries
    }
    availableCountries
  }

  @Override
  void getStatisticsForCountry(String countryName) {
    String validatedCountry = getAllCountries().response.find(){ countryBank ->
      countryBank == countryName
    }
    if(validatedCountry) {
      println(validatedCountry + " Country selected")
      RestTemplate restTemplate = new RestTemplate()
      String url = "https://covid-193.p.rapidapi.com/statistics?country={country}"
      HttpEntity<String> entity = new HttpEntity<String>("parameters", getHeaders())
      ResponseEntity<StatisticsResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, StatisticsResponse, validatedCountry)
      println "******"*20
      println(response.statusCode)
      println(response.body)
      println "******"*20
    }
  }

  @Override
  HttpHeaders getHeaders() {
    HttpHeaders headers = new HttpHeaders()
    headers.setContentType(APPLICATION_JSON)
    headers.add('x-rapidapi-key', apiKey)
    headers
  }

}
