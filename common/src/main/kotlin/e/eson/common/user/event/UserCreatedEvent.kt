package e.eson.common.user.event

import e.eson.common.event.AbstractEvent
import e.eson.common.user.UserIdentifiable

/**
 *   @Project: axon-spring-cloud-demo
 *   @Package: e.eson.common.user.event
 *   @Author:  Iamee
 *   @Date:    2019-05-08 15:11
 */

class UserCreatedEvent(
        override val userId: String = "",
        time: Long = 0L
) : AbstractEvent(time = time), UserIdentifiable