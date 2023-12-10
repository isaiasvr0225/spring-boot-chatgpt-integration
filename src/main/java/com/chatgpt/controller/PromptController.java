package com.chatgpt.controller;

import com.chatgpt.dto.PromptResponseDTO;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/prompt")
@RequiredArgsConstructor
public class PromptController {

    private final ChatgptService chatgptService;

    @GetMapping("/send")
    public PromptResponseDTO<String> sendPrompt(@RequestParam String message) {
        log.info("The message is: ", message );
        String response =  this.chatgptService.sendMessage(message);
        log.info("The response is: ", response );

        return PromptResponseDTO.succes(response);
    }
}
