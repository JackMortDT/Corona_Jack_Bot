package com.jack.discord.jackbot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["me.ramswaroop.jbot", "com.jack.discord.jackbot"])
class JackbotApplication {

  static void main(String[] args) {
    SpringApplication.run(JackbotApplication, args)
  }

}
