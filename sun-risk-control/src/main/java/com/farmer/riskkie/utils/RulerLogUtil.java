package com.farmer.riskkie.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName:
 * @Desc:
 * @Author: Sunzhigang
 * @Date: 2019/10/10 16:40
 */
@Slf4j
public class RulerLogUtil {

    public static void showLog(Object o){
        log.info("规则对象日志输出:{}",o);
    }
}
