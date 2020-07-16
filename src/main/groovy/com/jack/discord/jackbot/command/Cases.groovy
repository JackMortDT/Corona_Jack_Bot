package com.jack.discord.jackbot.command

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.ToString

@ToString
class Cases {

  @JsonProperty("new")
  Integer newCases

  Integer active
  Integer critical
  Integer recovered
  Integer total

}
