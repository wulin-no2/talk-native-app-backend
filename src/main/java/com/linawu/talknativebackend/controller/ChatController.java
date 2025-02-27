package com.linawu.talknativebackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @PostMapping("/message")
    public String getChatResponse(@RequestBody Map<String, String> request){
        String userMessage = request.get("message");
        return "Your message: " + userMessage;
    }
}
