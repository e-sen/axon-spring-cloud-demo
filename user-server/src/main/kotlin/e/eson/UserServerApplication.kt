package e.eson

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UserServerApplication

fun main(args: Array<String>) {
    runApplication<UserServerApplication>(*args)
}
