package com.chatgpt.dto;

public record ResponseDTO<T>(
        Integer statusCode,
        String message,
        T data
) {

    public static <T> ResponseDTO<T> succes(T data){
        return new ResponseDTO<>(200, "succes", data);
    }

    public static <T> ResponseDTO<T> failed(T data){
        return new ResponseDTO<>(500, "failed", data);
    }
}
