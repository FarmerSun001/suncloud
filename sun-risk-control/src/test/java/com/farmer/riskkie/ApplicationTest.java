package com.farmer.riskkie;

import com.farmer.riskkie.domain.Message;
import com.farmer.riskkie.utils.KieUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
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

    @Resource
    KieSession kieSession;
    @Test
    public void testRelus(){
        // load up the knowledge base
/*        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = KieUtils.getKieContainer();*/
//        KieSession kSession = KieUtils.getKieSession();
        // go !
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        kieSession.insert(message);//插入
        kieSession.fireAllRules();//执行规则
        kieSession.dispose();
        log.info("规则返回值{}",message.getMessage());
    }
}
