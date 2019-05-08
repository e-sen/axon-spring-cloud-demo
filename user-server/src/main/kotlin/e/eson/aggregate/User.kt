package e.eson.aggregate

import e.eson.common.user.event.*
import e.eson.common.user.exception.UserException
import org.axonframework.eventhandling.EventHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.modelling.command.AggregateMember
import org.axonframework.spring.stereotype.Aggregate


/**
 *   @Project: axon-spring-cloud-demo
 *   @Package: e.eson.aggregate
 *   @Author:  Iamee
 *   @Date:    2019-05-08 14:55
 */

@Aggregate
class User {

    @AggregateIdentifier
    lateinit var id: String

    @AggregateMember
    lateinit var userId: String

    constructor()

    constructor(userId: String, time: Long) {
        AggregateLifecycle.apply(UserCreatedEvent(userId = userId, time = time))
    }

    @EventHandler
    fun on(event: UserCreatedEvent) {
        this.id = event.getIdentifer()
        this.userId = event.userId
    }


    fun exception(time: Long) {
        throw UserException(userId = userId)
    }

}