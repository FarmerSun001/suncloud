package com.farmer.riskkie.controller;

import com.farmer.riskkie.domain.BaseEvent;
import com.farmer.riskkie.domain.LoginEvent;
import com.farmer.riskkie.service.KieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName:
 * @Desc:
 * @Author: Sunzhigang
 * @Date: 2019/10/11 17:56
 */
@Slf4j
@RestController
public class LoginController {
    @Resource
    private KieService kieService;

    public void login(String ip, String mobile) {
        BaseEvent event = new LoginEvent(mobile, ip, ip);
        event.setOperateTime(new Date());
        kieService.execute(event);
    }
}
