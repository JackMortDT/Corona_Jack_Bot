package com.jack.discord.jackbot.command

import com.fasterxml.jackson.annotation.JsonProperty

class Cases {

  @JsonProperty("new")
  Integer newCases
  Integer active
  Integer critical
  Integer recovered
  Integer total


  @Override
  String toString() {
    """Cases: {
         New cases: ${newCases?:0},
         Active: ${active?:0},
         Critical: ${critical?:0},
         Recovered: ${recovered?:0},
         Total: ${total?:0}
    }"""
  }
}
