package e.esen.listener

import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Service

/**
 *   @Project: rest-command-server
 *   @Package: e.esen.listener
 *   @Author:  Iamee
 *   @Date:    2019-05-08 16:04
 */

@Service
class InitApplicationListener : ApplicationListener<ApplicationEvent> {

    override fun onApplicationEvent(event: ApplicationEvent) {
        println(event::class.simpleName)
    }

}