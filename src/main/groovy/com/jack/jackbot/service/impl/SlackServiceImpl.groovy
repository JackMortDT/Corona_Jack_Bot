package com.jack.jackbot.service.impl

import me.ramswaroop.jbot.core.slack.Bot
import org.springframework.stereotype.Service

@Service
class SlackServiceImpl extends Bot implements SlackService{


  @Override
  String getSlackToken() {
    return null
  }

  @Override
  Bot getSlackBot() {
    return null
  }
}
