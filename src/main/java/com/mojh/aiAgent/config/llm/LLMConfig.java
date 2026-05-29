package com.mojh.aiAgent.config.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LLMConfig {

    @Value("${qwen.base-url}")
    private String qwenBaseUrl;

    @Value("${qwen.api-key}")
    private String qwenApiKey;

    @Value("${qwen.model-name}")
    private String qwenModelName;

    @Value("${deepseek.base-url}")
    private String deepseekBaseUrl;

    @Value("${deepseek.api-key}")
    private String deepseekApiKey;

    @Value("${deepseek.model-name}")
    private String deepseekModelName;

    /**
     * 手动创建 Qwen 模型 Bean
     * 这里我们创建带名称的 Bean 以便区分
     */
    @Bean("qwenModel")
    public ChatModel qwenModel() {
        return OpenAiChatModel.builder()
                .baseUrl(qwenBaseUrl)
                .apiKey(qwenApiKey)
                .modelName(qwenModelName)
                .build();
    }

    @Bean("deepseekModel")
    public ChatModel deepseekModel() {
        return OpenAiChatModel.builder()
                .baseUrl(deepseekBaseUrl)
                .apiKey(deepseekApiKey)
                .modelName(deepseekModelName)
                .build();
    }
}
