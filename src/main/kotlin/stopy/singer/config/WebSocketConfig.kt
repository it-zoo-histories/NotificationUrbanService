package stopy.singer.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.messaging.simp.config.MessageBrokerRegistry


@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig : WebSocketMessageBrokerConfigurer {
    companion object {
        private const val WEB_SOCKET_ADDRESS = "/stopy_singer"
        private const val BROKER_NAME = "/stop"
    }

    override fun configureMessageBroker(config: MessageBrokerRegistry?) {
        config!!.enableSimpleBroker(BROKER_NAME)
        config.setApplicationDestinationPrefixes("/app")
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry?) {
        registry!!.addEndpoint(WEB_SOCKET_ADDRESS).withSockJS()
    }

}