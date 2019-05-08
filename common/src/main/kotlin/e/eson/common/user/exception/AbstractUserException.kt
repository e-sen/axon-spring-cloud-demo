package e.eson.common.user.exception

import e.eson.common.exception.AbstractException
import e.eson.common.user.UserIdentifiable

/**
 *   @Project: axon-spring-cloud-demo
 *   @Package: e.eson.common.user.exception
 *   @Author:  Iamee
 *   @Date:    2019-05-08 15:28
 */

abstract class AbstractUserException : AbstractException, UserIdentifiable {

    final override var userId: String = ""

    constructor()

    constructor(userId: String) : super(message = userId) {
        this.userId = userId
    }

    constructor(userId: String, message: String) : super(message = message) {
        this.userId = userId
    }

}