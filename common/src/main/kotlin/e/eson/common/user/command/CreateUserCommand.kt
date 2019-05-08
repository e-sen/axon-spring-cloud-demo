package e.eson.common.user.command

/**
 *   @Project: axon-spring-cloud-demo
 *   @Package: e.eson.common.user.command
 *   @Author:  Iamee
 *   @Date:    2019-05-08 15:12
 */

class CreateUserCommand(
        userId: String = ""
) : AbstractUserCommand(userId = userId)