package com.jack.jackbot.command

class CountryResponse {

  String country
  Cases cases
  Deaths deaths
  String day
  String time

  @Override
  String toString() {
    """CountryResponse: {
      Country: ${country},
      ${cases},
      ${deaths},
      Day: ${day},
      Time: ${time}
    }"""
  }

}
