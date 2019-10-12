package com.farmer.riskkie;

import com.farmer.riskkie.controller.LoginController;
import com.farmer.riskkie.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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
    KieContainer kieContainer;
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    LoginController loginController;

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

    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("test", "测试Redis");

        String test = (String) stringRedisTemplate.opsForValue().get("test");
        log.info("测试Redis:{}", test);
    }

    @Test
    public void testLogin() {
        for (int i = 0; i < 100; i++) {
            if (i / 10 == 5) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            loginController.login("192.168.12.205", "18588205431" + i);
        }
    }
}
