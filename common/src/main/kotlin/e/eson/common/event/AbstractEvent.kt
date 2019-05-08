package e.eson.common.event

import e.eson.common.Identifiable

/**
 *   @Project: axon-spring-cloud-demo
 *   @Package: e.eson.common.event
 *   @Author:  Iamee
 *   @Date:    2019-05-08 14:50
 */

abstract class AbstractEvent(val time: Long) : Identifiable