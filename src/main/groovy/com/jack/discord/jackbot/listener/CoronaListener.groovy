package com.jack.discord.jackbot.listener

import net.dv8tion.jda.api.entities.ChannelType
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class CoronaListener extends ListenerAdapter{

  @Override
  void onMessageReceived(MessageReceivedEvent event) {
    if(event.isFromType(ChannelType.PRIVATE)) {
      println("[PM] ${event.author.name}, ${event.message.contentDisplay}")
    } else {
      println("${event.guild.name}, ${event.textChannel.name}, ${event.member.effectiveName}, ${event.message.contentDisplay}")
    }
  }

}
