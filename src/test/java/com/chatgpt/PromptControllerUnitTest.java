package com.chatgpt;

import com.chatgpt.controller.PromptController;
import com.chatgpt.dto.PromptResponseDTO;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class PromptControllerUnitTest {
    @Mock
    private ChatgptService chatgptService;

    @InjectMocks
    private PromptController promptController;

    @Test
    public void sendPrompt_success() throws Exception {
        // Define test data
        String message = "Test message";
        String expectedResponse = "ChatGPT response";

        // Mock chatgptService behavior
        Mockito.when(chatgptService.sendMessage(message)).thenReturn(expectedResponse);

        // Execute the controller method
        PromptResponseDTO<String> response = promptController.sendPrompt(message);

        // Assert the response
        assertEquals(PromptResponseDTO.succes(expectedResponse), response);

        // Verify log messages
        verify(log).info("The message is: ", message);
        verify(log).info("The response is: ", expectedResponse);
    }
}
