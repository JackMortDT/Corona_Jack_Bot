package com.jack.discord.jackbot.command

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.ToString

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
class StatisticsResponse {

  Integer results

  @JsonProperty("response")
  List<CountryResponse> countriesList

}
