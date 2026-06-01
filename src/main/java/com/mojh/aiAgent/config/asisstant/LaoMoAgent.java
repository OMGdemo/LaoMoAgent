package com.mojh.aiAgent.config.asisstant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        streamingChatModel = "qwenStreamingModel",
        chatMemoryProvider = "chatAssistantLaoMoProvider",
        tools = {"appointmentTools", "calculatorTools"},
        contentRetriever = "contentRetriever")
public interface LaoMoAgent {

    @SystemMessage(fromResource = "laoMo-agent-systemMessage.txt")
    Flux<String> chat(@MemoryId String memoryId, @UserMessage String userMessage);
}
