package com.mojh.aiAgent;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LLMTest {

    // 测试LLM
    @Test
    public void testLLM() {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();
        String answer = model.chat("你是谁");
        System.out.println(answer);
    }

    // 测试springboot接入千问大模型LLM
    @Autowired
    @Qualifier("qwenModel")
    private ChatModel qwenModel;

    @Test
    public void testSpringBootQwenLLM() {
        String answer = qwenModel.chat("你是谁");
        System.out.println(answer);
    }

    // 测试springboot接入deepseek大模型LLM
    @Autowired
    @Qualifier("deepseekModel")
    private ChatModel deepseekModel;

    @Test
    public void testSpringBootDeepseekLLM() {
        String answer = deepseekModel.chat("你是谁");
        System.out.println(answer);
    }

    /**
     * ollama接入
     */
    @Autowired
    private OllamaChatModel ollamaChatModel;
    @Test
    public void testOllama() {
        String answer = ollamaChatModel.chat("你好");
        System.out.println(answer);
    }
}
