package com.mojh.aiAgent.config.asisstant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenModel",
        chatMemoryProvider = "chatPersistenceMemoryProvider")
public interface ChatPersistenceAssistant {

    String chat(@MemoryId String memoryId, @UserMessage String userMessage);
}
