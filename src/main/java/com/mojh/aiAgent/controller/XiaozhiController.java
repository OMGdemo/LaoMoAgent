package com.mojh.aiAgent.controller;

import com.mojh.aiAgent.bean.ChatForm;
import com.mojh.aiAgent.config.asisstant.LaoMoAgent;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Tag(name = "老莫agent")
@RestController
@RequestMapping("/xiaozhi")
public class XiaozhiController {

    @Autowired
    private LaoMoAgent loamoAgent;

    @Operation(summary = "对话")
    @PostMapping(value = "/chat", produces = "text/stream;charset=utf-8")
    public Flux<String> chat(@RequestBody ChatForm chatForm) {
        return loamoAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }
}