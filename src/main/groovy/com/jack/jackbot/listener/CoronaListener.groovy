package com.jack.jackbot.listener

import com.jack.jackbot.service.DiscordService
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CoronaListener extends ListenerAdapter{

  @Autowired
  DiscordService discordService

  @Override
  void onMessageReceived(MessageReceivedEvent event) {
    if(event.message.author.isBot()) return
    discordService.discordMenu(event)
  }

}
