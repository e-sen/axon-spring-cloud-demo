package e.eson.config

import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore
import org.axonframework.eventsourcing.eventstore.EventStorageEngine
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine
import org.axonframework.spring.config.AxonConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

/**
 *   @Project: axon-spring-cloud-demo
 *   @Package: e.eson.config
 *   @Author:  Iamee
 *   @Date:    2019-05-08 14:55
 */

@Configuration
class AxonInMemoryStorage {

    @Bean
    fun storageEngine(): EventStorageEngine {
        return InMemoryEventStorageEngine()
    }

    @Bean
    fun eventStore(storageEngine: EventStorageEngine, configuration: AxonConfiguration): EmbeddedEventStore {
        return EmbeddedEventStore.builder()
                .storageEngine(storageEngine)
                .messageMonitor(configuration.messageMonitor(EventStore::class.java, "eventStore"))
                .build()
    }

}