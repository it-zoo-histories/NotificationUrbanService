package stopy.singer.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @RequestMapping("/test", method = [RequestMethod.GET])
    fun test(): String {
        return "Hello bitch"
    }
}