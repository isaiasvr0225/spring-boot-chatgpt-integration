package com.chatgpt.dto;

public record PromptResponseDTO<T>(
        Integer statusCode,
        String message,
        T data
) {

    public static <T> PromptResponseDTO<T> succes(T data){
        return new PromptResponseDTO<>(200, "succes", data);
    }

    public static <T> PromptResponseDTO<T> failed(T data){
        return new PromptResponseDTO<>(500, "failed", data);
    }
}
