package com.jack.discord.jackbot.controller

import com.jack.discord.jackbot.service.CoronaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CovidController {

  @Autowired
  CoronaService coronaService

  @GetMapping("/test123")
  void test123() {
    coronaService.getStatisticsForCountry("Argentina")
  }
}
