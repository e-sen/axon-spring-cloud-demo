package e.esen.controller

import e.esen.controller.req.CreateUserReq
import e.esen.controller.req.ExceptionUserReq
import e.esen.controller.res.ExceptionUserRes
import e.eson.common.user.command.CreateUserCommand
import e.eson.common.user.command.ExceptionUserCommand
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

/**
 *   @Project: rest-command-server
 *   @Package: e.esen.controller
 *   @Author:  Iamee
 *   @Date:    2019-05-08 15:41
 */

@RestController
@RequestMapping("/api/user")
class UserController {

    @Autowired
    lateinit var commandGateway: CommandGateway

    @PostMapping("/")
    fun create(@RequestBody body: CreateUserReq): ResponseEntity<Any> {
        val userId = commandGateway.sendAndWait<String>(CreateUserCommand(userId = body.userId))
        return ResponseEntity.created(URI("user/$userId")).build()
    }

    @PostMapping("/exception")
    fun exception(@RequestBody body: ExceptionUserReq): ResponseEntity<ExceptionUserRes> {
        try {
            commandGateway.sendAndWait<String>(ExceptionUserCommand(userId = body.userId))
        } catch (ex: Exception) {
            return ResponseEntity.ok(ExceptionUserRes(exceptionType = ex::class.qualifiedName!!, message = ex.message!!))
        }
        return ResponseEntity.ok().build()
    }

}