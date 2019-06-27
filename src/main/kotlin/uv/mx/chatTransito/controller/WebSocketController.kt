package uv.mx.chatTransito.controller

import java.text.SimpleDateFormat
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import java.util.*


@Controller
class WebSocketController @Autowired
internal constructor(private val template: SimpMessagingTemplate) {

    @MessageMapping("/send/mensaje")
    fun onReceivedMesage(message: String) {
        this.template.convertAndSend("/chat", SimpleDateFormat("hh:mm:ss a").format(Date()) + " - " + message)
    }
}