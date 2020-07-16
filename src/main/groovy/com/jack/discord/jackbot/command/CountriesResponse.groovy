package com.jack.discord.jackbot.command

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class CountriesResponse {

  Integer results
  List<String> response

}
