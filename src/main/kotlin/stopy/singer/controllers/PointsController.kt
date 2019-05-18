package stopy.singer.controllers

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class PointsController {

    @MessageMapping("/hello")
    @SendTo("/stop/points")
    fun test(): String {
        return "Hello"
    }
}