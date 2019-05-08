package e.eson.handler

import e.eson.aggregate.User
import e.eson.common.CommonService
import e.eson.common.user.command.CreateUserCommand
import e.eson.common.user.command.ExceptionUserCommand
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.modelling.command.Repository
import org.springframework.stereotype.Component

/**
 *   @Project: user-server
 *   @Package: e.eson.handler
 *   @Author:  Iamee
 *   @Date:    2019-05-08 15:24
 */

@Component
class UserCommandHandler(
        val repository: Repository<User>,
        val service: CommonService
) {

    @CommandHandler
    fun handle(command: CreateUserCommand): String {
        repository.newInstance { User(userId = command.userId, time = service.currentTimeMillis()) }
        return command.userId
    }

    @CommandHandler
    fun handle(command: ExceptionUserCommand): String {
        repository.load(command.getIdentifer()).invoke {
            it.exception(time = service.currentTimeMillis())
        }
        return command.userId
    }

}