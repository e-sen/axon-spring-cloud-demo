package e.eson.common.user

import e.eson.common.Identifiable

/**
 *   @Project: axon-spring-cloud-demo
 *   @Package: e.eson.common.user
 *   @Author:  Iamee
 *   @Date:    2019-05-08 15:07
 */

interface UserIdentifiable : Identifiable {

    val userId: String

    override fun getIdentifer(): String {
        return "User( id = $userId )"
    }

}