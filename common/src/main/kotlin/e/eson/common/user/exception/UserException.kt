package e.eson.common.user.exception

/**
 *   @Project: axon-spring-cloud-demo
 *   @Package: e.eson.common.user.exception
 *   @Author:  Iamee
 *   @Date:    2019-05-08 15:29
 */

class UserException : AbstractUserException {

    override val code: Int = 1

    constructor()

    constructor(userId: String) : super(userId = userId)

}