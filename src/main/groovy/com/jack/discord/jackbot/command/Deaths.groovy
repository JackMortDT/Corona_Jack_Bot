package com.jack.discord.jackbot.command

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.ToString

@ToString
class Deaths {

  @JsonProperty("new")
  Integer newDeaths

  Integer total

}
