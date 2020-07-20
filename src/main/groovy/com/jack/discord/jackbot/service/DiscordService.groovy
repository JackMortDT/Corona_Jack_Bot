package com.jack.discord.jackbot.service

import net.dv8tion.jda.api.events.message.MessageReceivedEvent

interface DiscordService {

  void discordMenu(MessageReceivedEvent event)
  void help(MessageReceivedEvent event)
  void fetchStatistics(MessageReceivedEvent event)

}
