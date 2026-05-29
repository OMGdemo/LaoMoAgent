package com.mojh.aiAgent.config.memory;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatMemoryProviderConfig {

    @Autowired
    private RedisChatMemoryStore redisChatMemoryStore;

    @Bean("chatMemoryProvider")
    public ChatMemoryProvider chatMemoryProvider() {
        return memoryId -> {
            // 创建一个基于消息窗口的聊天记忆
            return MessageWindowChatMemory.builder().id(memoryId).maxMessages(10).build();
        };
    }

    @Bean("chatPersistenceMemoryProvider")
    public ChatMemoryProvider chatPersistenceMemoryProvider() {
        return memoryId -> {
            // 创建一个基于消息窗口的聊天记忆
            return MessageWindowChatMemory.builder().id(memoryId).maxMessages(10).chatMemoryStore(redisChatMemoryStore).build();
        };
    }
}
