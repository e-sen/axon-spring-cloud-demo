package e.eson.config

import org.axonframework.commandhandling.CommandBus
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.serialization.Serializer
import org.axonframework.serialization.json.JacksonSerializer
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

/**
 *   @Project: user-server
 *   @Package: e.eson.config
 *   @Author:  Iamee
 *   @Date:    2019-05-08 15:32
 */

@Configuration
class AxonConfig {

    @Bean
    @Primary
    fun serializer(): Serializer {
        return JacksonSerializer.builder().build()
    }

    @Bean
    @Qualifier("localSegment")
    fun commandBus(): CommandBus {
        return SimpleCommandBus.builder().build()
    }

}