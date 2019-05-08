package e.eson.common.user.command

import e.eson.common.command.AbstractCommand
import e.eson.common.user.UserIdentifiable

/**
 *   @Project: axon-spring-cloud-demo
 *   @Package: e.eson.common.user.command
 *   @Author:  Iamee
 *   @Date:    2019-05-08 15:23
 */

abstract class AbstractUserCommand(
        override val userId: String
) : AbstractCommand(), UserIdentifiable