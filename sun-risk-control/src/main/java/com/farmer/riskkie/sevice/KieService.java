package com.farmer.riskkie.sevice;

import lombok.extern.slf4j.Slf4j;
import org.kie.api.io.ResourceType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
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


    private void addPackage(String packageName) {
        URL url = this.getClass().getClassLoader().getResource(packageName);
        if (url != null) {
            File path = new File(url.getPath());
            KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
            File[] files = path.listFiles();
            if (files == null) {
                log.error("**********加载规则失败**************");
                return;
            }
            for (File file : files) {
                if (file.getName().endsWith(".drl")) {
                    knowledgeBuilder.add(ResourceFactory.newClassPathResource(packageName + "/" + file.getName()), ResourceType.DRL);
                    if (knowledgeBuilder.hasErrors()) {
                        log.error("**********加载规则失败**************");
                        return;
                    }else {

                    }

                }
            }
        } else {
            log.error("**********加载规则失败**************");
        }
    }


    @PostConstruct
    public void init() {
        addPackage("rules");
    }
}
