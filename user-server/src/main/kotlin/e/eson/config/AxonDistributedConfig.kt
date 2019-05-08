package e.eson.config

import org.axonframework.commandhandling.CommandBus
import org.axonframework.commandhandling.distributed.AnnotationRoutingStrategy
import org.axonframework.commandhandling.distributed.CommandBusConnector
import org.axonframework.commandhandling.distributed.CommandRouter
import org.axonframework.commandhandling.distributed.DistributedCommandBus
import org.axonframework.extensions.springcloud.commandhandling.SpringCloudCommandRouter
import org.axonframework.extensions.springcloud.commandhandling.SpringHttpCommandBusConnector
import org.axonframework.serialization.Serializer
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cloud.client.ServiceInstance
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.cloud.client.serviceregistry.Registration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.web.client.RestOperations
import org.springframework.web.client.RestTemplate
import java.net.URI

/**
 *   @Project: axon-spring-cloud-demo
 *   @Package: e.eson.config
 *   @Author:  Iamee
 *   @Date:    2019-05-08 14:55
 */

@Configuration
class AxonDistributedConfig {

    @Bean
    fun restOperations(): RestOperations {
        return RestTemplate()
    }

    @Bean
    fun springCloudCommandRouter(client: DiscoveryClient, serviceInstance: ServiceInstance): CommandRouter {
        return SpringCloudCommandRouter.builder()
                .discoveryClient(client)
                .localServiceInstance(makeRegistration(serviceInstance))
                .routingStrategy(AnnotationRoutingStrategy())
                .build()
    }

    @Bean
    fun springHttpCommandBusConnector(serializer: Serializer, restOperations: RestOperations, @Qualifier("localSegment") commandBus: CommandBus): CommandBusConnector {
        return SpringHttpCommandBusConnector.builder()
                .serializer(serializer)
                .restOperations(restOperations)
                .localCommandBus(commandBus)
                .build()
    }

    @Bean
    @Primary
    fun springCloudDistributedCommandBus(router: CommandRouter, connector: CommandBusConnector): DistributedCommandBus {
        return DistributedCommandBus.builder()
                .commandRouter(router)
                .connector(connector)
                .build()
    }

    fun makeRegistration(serviceInstance: ServiceInstance): Registration {
        return object : Registration {
            override fun getServiceId(): String {
                return serviceInstance.serviceId
            }

            override fun getMetadata(): MutableMap<String, String> {
                return serviceInstance.metadata
            }

            override fun getPort(): Int {
                return serviceInstance.port
            }

            override fun getHost(): String {
                return serviceInstance.host
            }

            override fun getUri(): URI {
                return serviceInstance.uri
            }

            override fun isSecure(): Boolean {
                return serviceInstance.isSecure
            }

        }
    }

}