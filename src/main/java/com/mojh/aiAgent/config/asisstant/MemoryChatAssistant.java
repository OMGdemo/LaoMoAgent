package com.mojh.aiAgent.config.asisstant;

import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenModel",
        chatMemory = "chatMemoryMessageWindow")
public interface MemoryChatAssistant {

    String chatMemory(String userMessage);
}
