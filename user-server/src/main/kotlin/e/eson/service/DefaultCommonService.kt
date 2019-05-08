package e.eson.service

import e.eson.common.CommonService
import org.springframework.stereotype.Service

/**
 *   @Project: user-server
 *   @Package: e.eson.service
 *   @Author:  Iamee
 *   @Date:    2019-05-08 15:38
 */

@Service
class DefaultCommonService : CommonService {
    override fun currentTimeMillis(): Long {
        return System.currentTimeMillis()
    }
}