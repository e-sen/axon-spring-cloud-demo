package e.eson.config

import e.eson.aggregate.User
import org.axonframework.eventsourcing.AggregateFactory
import org.axonframework.eventsourcing.EventSourcingRepository
import org.axonframework.eventsourcing.GenericAggregateFactory
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.modelling.command.Repository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 *   @Project: user-server
 *   @Package: e.eson.config
 *   @Author:  Iamee
 *   @Date:    2019-05-08 15:32
 */

@Configuration
class AggregateConfig {

    @Bean
    fun userAggregateFactory(): AggregateFactory<User> {
        return GenericAggregateFactory(User::class.java)
    }

    @Bean
    fun userSimpleRepository(eventStore: EventStore, aggregateFactory: AggregateFactory<User>): Repository<User> {
        return EventSourcingRepository.builder(User::class.java).eventStore(eventStore).aggregateFactory(aggregateFactory).build()
    }

}