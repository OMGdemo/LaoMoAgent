package com.mojh.aiAgent.config.memory;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LaoMoAgentProviderConfig {

    @Autowired
    private RedisChatMemoryStore redisChatMemoryStore;

    @Bean("chatAssistantLaoMoProvider")
    public ChatMemoryProvider chatPersistenceMemoryProvider() {
        return memoryId -> {
            return MessageWindowChatMemory.builder().id(memoryId).maxMessages(20).chatMemoryStore(redisChatMemoryStore).build();
        };
    }
}
