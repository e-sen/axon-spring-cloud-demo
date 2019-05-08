package e.eson.common

import com.fasterxml.jackson.annotation.JsonIgnore
import org.axonframework.modelling.command.TargetAggregateIdentifier

/**
 *   @Project: axon-spring-cloud-demo
 *   @Package: e.eson.common
 *   @Author:  Iamee
 *   @Date:    2019-05-08 14:46
 */

interface Identifiable {

    @JsonIgnore
    @TargetAggregateIdentifier
    fun getIdentifer(): String

}