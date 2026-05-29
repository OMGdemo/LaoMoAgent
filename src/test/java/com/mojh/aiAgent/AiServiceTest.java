package com.mojh.aiAgent;

import com.mojh.aiAgent.config.asisstant.Assistant;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AiServiceTest {
    @Autowired
    @Qualifier("qwenModel")
    private ChatModel qwenModel;

    @Autowired
    @Qualifier("deepseekModel")
    private ChatModel deepseekModel;

    // 手动创建 Assistant Bean
    @Test
    public void testChat() {
        Assistant assistant = AiServices.create(Assistant.class, qwenModel);
        String answer = assistant.chat("你是谁");
        System.out.println(answer);
    }

    // 使用 @AiService 注解创建 Assistant Bean，代码中直接使用
    @Autowired
    private Assistant assistant;
    @Test
    public void testAssistant() {
        String answer = assistant.chat("你是谁");
        System.out.println(answer);
    }
}
