package com.farmer.riskkie.sevice;

import lombok.extern.slf4j.Slf4j;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.drools.core.impl.KnowledgeBaseImpl;
import org.drools.core.marshalling.impl.ProtobufMessages;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

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
    private StatelessKieSession kieSession;

    /**
     * 规则引擎执行
     *
     * @param object
     */
    public void execute(Object object) {
        this.kieSession.execute(object);
    }


}
