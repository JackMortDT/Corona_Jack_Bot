package com.jack.jackbot.command

import com.fasterxml.jackson.annotation.JsonProperty

class Deaths {

  @JsonProperty("new")
  Integer newDeaths
  Integer total


  @Override
  String toString() {
    """Deaths: {
      New Deaths: ${newDeaths?:0},
      Total: ${total?:0}
    }"""
  }
}
