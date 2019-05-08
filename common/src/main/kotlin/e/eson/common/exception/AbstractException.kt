package e.eson.common.exception

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonTypeInfo

/**
 *   @Project: axon-spring-cloud-demo
 *   @Package: e.eson.common.exception
 *   @Author:  Iamee
 *   @Date:    2019-05-08 14:50
 */

@JsonIgnoreProperties("cause", "stackTrace", "suppressed", "localizedMessage", ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class AbstractException : RuntimeException {

    abstract val code: Int

    constructor()

    constructor(message: String) : super(message)

    constructor(cause: Throwable) : super(cause)

}