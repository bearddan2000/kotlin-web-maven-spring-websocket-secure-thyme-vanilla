package example.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class ClickController {

  @Throws(Exception::class)
  @MessageMapping("/click")
  @SendTo("/topic/click")
  fun greeting(clicks :example.model.Input) :example.model.Output {
    return example.model.Output()
  }
}
