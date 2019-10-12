package com.farmer.riskkie.service;

import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @ClassName:
 * @Desc:
 * @Author: Sunzhigang
 * @Date: 2019/10/9 16:26
 */
@Slf4j
@Service
public class KieService {

    @Resource
    private DimensionService dimensionService;

    @Resource
    private StatelessKieSession kieSession;

    /**
     * 设置规则全局变量
     * */
    @PostConstruct
    private void setGlobal() {
        kieSession.setGlobal("dimensionService", dimensionService);
    }

    /**
     * 规则引擎执行
     *
     * @param object
     */
    public void execute(Object object) {
        this.kieSession.execute(object);
    }


}
