package stopy.singer.controllers

import org.springframework.stereotype.Controller
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.simp.annotation.SubscribeMapping
import org.springframework.web.bind.annotation.CrossOrigin


@Controller
class PointsController {
    @Autowired
    private lateinit var template: SimpMessagingTemplate

    private val currentUsers: MutableList<Long> = ArrayList()

    //    this.template.convertAndSend("/stop/points/{user_id}", "message");
    init {
        huhu()
    }

    @SubscribeMapping("/stop/points/{user_id}")
    @CrossOrigin("*")
    fun test(@DestinationVariable("user_id") userId: Long): String {
        println("user_id $userId")
        currentUsers.add(userId)
        return "You connected bitch"
    }

    fun huhu() {
        Thread {
            Thread.sleep(1000)
            currentUsers.forEach {
                this.template.convertAndSend("/stop/points/$it", "message")
            }
        }.start()
    }

}