package com.farmer.riskkie;

import com.farmer.riskkie.domain.Message;
import com.farmer.riskkie.sevice.KieService;
import com.farmer.riskkie.utils.KieUtils;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName:
 * @Desc:
 * @Author: Sunzhigang
 * @Date: 2019/10/10 10:29
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SunRiskKieApplication.class})
public class ApplicationTest {

//    @Autowired
//    KieService kieService;
    @Resource
    KieContainer kieContainer;

    @Test
    public void testRelus() {
//        KieServices kieServices = KieServices.get();
//        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession();
        // go !
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
 /*       kieSession.insert(message);//插入
        kieSession.fireAllRules();//执行规则
        kieSession.dispose();*/
        kieSession.execute(message);
        log.info("规则返回值{}", message.getMessage());
    }
}
