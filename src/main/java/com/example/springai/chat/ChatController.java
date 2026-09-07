package com.example.springai.chat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @PostMapping
    public ChatResponse chat(@Valid @RequestBody ChatRequest request) {
        try {
            String answer = chatClient.prompt()
                    .user(request.message())
                    .call()
                    .content();
            return new ChatResponse(answer);
        }
        catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_GATEWAY,
                    "The AI provider could not complete the request.",
                    exception);
        }
    }

    public record ChatRequest(@NotBlank(message = "message must not be blank") String message) {
    }

    public record ChatResponse(String response) {
    }
}
