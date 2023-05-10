package uk.co.pitchitltd.chat.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ChatController {

    @GetMapping("/")
    fun index(): String {
        return "index"
    }

}