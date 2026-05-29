package com.mojh.aiAgent.bean;

import lombok.Data;

@Data
public class ChatForm {
    private String memoryId;//对话id
    private String message;//用户问题
}