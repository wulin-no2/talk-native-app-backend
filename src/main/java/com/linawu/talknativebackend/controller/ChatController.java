package com.linawu.talknativebackend.controller;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.linawu.talknativebackend.constant.Prompt.PROMPT_SETTING;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final OpenAiChatModel chatModel;

    public ChatController(OpenAiChatModel chatModel){
        this.chatModel = chatModel;
    }

    @PostMapping("/message")
    public String getChatResponse(@RequestBody Map<String, String> request){
        String userMessage = request.get("message");
        return chatModel.call(PROMPT_SETTING + userMessage);
    }

    // Dedicated Health Check Endpoint
    @GetMapping("/health")
    public String checkHealthy(){
        return "OK";
    }
}
