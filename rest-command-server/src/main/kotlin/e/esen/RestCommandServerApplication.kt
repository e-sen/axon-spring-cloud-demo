package e.esen

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestCommandServerApplication

fun main(args: Array<String>) {
    runApplication<RestCommandServerApplication>(*args)
}
