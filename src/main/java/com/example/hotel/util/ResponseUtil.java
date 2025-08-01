package com.example.hotel.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class ResponseUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> createSuccessResponse(Object body) {
        try {
            return Map.of(
                "statusCode", 200,
                "headers", Map.of("Content-Type", "application/json"),
                "body", objectMapper.writeValueAsString(body)
            );
        } catch (Exception e) {
            return createErrorResponse(500, "Failed to serialize response");
        }
    }

    public static Map<String, Object> createErrorResponse(int statusCode, String message) {
        return Map.of(
            "statusCode", statusCode,
            "headers", Map.of("Content-Type", "application/json"),
            "body", String.format("{\"error\": \"%s\"}", message)
        );
    }
}