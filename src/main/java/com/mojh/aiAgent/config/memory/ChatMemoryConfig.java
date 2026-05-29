package com.mojh.aiAgent.config.memory;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.TokenCountEstimator;
import dev.langchain4j.model.openai.OpenAiTokenCountEstimator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatMemoryConfig {

    @Bean("chatMemoryMessageWindow")
    public ChatMemory chatMemoryMessageWindow() {
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);
        return chatMemory;
    }

    @Bean("chatMemoryMessageToken")
    public ChatMemory chatMemoryMessageToken() {
        // 1 TokenCountEstimator默认的token分词器，需要结合Tokenizer计算ChatMessage的token数量
        TokenCountEstimator openAiTokenCountEstimator = new OpenAiTokenCountEstimator("gpt-4");
        TokenWindowChatMemory chatMemory = TokenWindowChatMemory.withMaxTokens(1000,openAiTokenCountEstimator);
        return chatMemory;
    }
}
