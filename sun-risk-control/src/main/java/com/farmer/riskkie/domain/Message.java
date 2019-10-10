package com.farmer.riskkie.domain;

import lombok.Data;

/**
 * @ClassName:
 * @Desc:
 * @Author: Sunzhigang
 * @Date: 2019/10/9 17:24
 */
@Data
public class Message {
    public static final Integer HELLO = 0;
    public static final Integer GOODBYE = 1;

    private String message;

    private Integer status;
}

