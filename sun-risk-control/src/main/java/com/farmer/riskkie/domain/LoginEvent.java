package com.farmer.riskkie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName:
 * @Desc: 风控登录事件
 * @Author: Sunzhigang
 * @Date: 2019/10/11 11:00
 */
@AllArgsConstructor
@Data
public class LoginEvent extends BaseEvent implements Serializable {


    public final static String MOBILE = "mobile";

    public final static String OPERATEIP = "operateIp";

    /**
     * 手机号
     */
    private String mobile;

    /**
     * ip地址
     */
    private String ip;

    /**
     * IP逆向地理位置
     */
    private String operateIp;

    @Override
    public String toString() {
        return "LoginEvent{" +
                "mobile='" + mobile + '\'' +
                ", ip='" + ip + '\'' +
                ", operateIp='" + operateIp + '\'' +
                ", operateTime='" + getOperateTime() + '\'' +
                '}';
    }
}
