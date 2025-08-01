package com.example.hotel;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.hotel.util.ResponseUtil;

import java.util.Map;
import java.util.Optional;

public class HotelApiLambda implements RequestHandler<Map<String, Object>, Map<String, Object>> {

    private final Router router = new Router();

    @Override
    public Map<String, Object> handleRequest(Map<String, Object> event, Context context) {
        try {
            //extract path using Optional
            String path = Optional.ofNullable((String) event.get("path"))
                                  .filter(p -> !p.trim().isEmpty())
                                  .orElseThrow(() -> new IllegalArgumentException("Missing or invalid path"));

            //extract query parameters
            @SuppressWarnings("unchecked")
            Map<String, String> queryParams = (Map<String, String>) event.get("queryStringParameters");

            // to route
            return router.route(path, queryParams);

        } catch (IllegalArgumentException e) {
            // Handle validation errors
            return ResponseUtil.createErrorResponse(400, e.getMessage());

        } catch (Exception e) {
            // Catch for unexpected errors
            return ResponseUtil.createErrorResponse(500, "Internal server error: " + e.getMessage());
        }
    }
}