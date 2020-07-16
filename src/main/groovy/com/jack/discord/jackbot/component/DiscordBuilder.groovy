package com.jack.discord.jackbot.component

import com.jack.discord.jackbot.listener.CoronaListener
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct
import javax.security.auth.login.LoginException

@Component
class DiscordBuilder {

  @Value('${discord.bot.token}')
  String botToken

  @PostConstruct
  void buildDiscordBot() throws LoginException{
    JDA jda = JDABuilder.createDefault(botToken).build()
    jda.addEventListener(new CoronaListener())
  }

}
