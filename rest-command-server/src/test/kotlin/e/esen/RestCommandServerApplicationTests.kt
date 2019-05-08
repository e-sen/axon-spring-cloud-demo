package e.esen

import e.eson.common.user.command.CreateUserCommand
import e.eson.common.user.command.ExceptionUserCommand
import e.eson.common.user.exception.UserException
import org.axonframework.commandhandling.gateway.CommandGateway
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class RestCommandServerApplicationTests {

    @Autowired
    lateinit var commandGateway: CommandGateway

    var userId = "userId"

    @Before
    fun setup() {
        commandGateway.send<String>(CreateUserCommand(userId = userId))
    }

    @Test(expected = UserException::class)
    fun exception() {
        commandGateway.sendAndWait<String>(ExceptionUserCommand(userId = userId))
    }

}
