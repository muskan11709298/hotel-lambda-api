package com.example.hotel.service;
 
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.example.hotel.model.HotelResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
 
public class AvailableHotelsService {
 
    private final ObjectMapper objectMapper = new ObjectMapper();
 
    public String processAvailability(APIGatewayProxyRequestEvent request) {
        String queryParams = request.getQueryStringParameters().toString();
        HotelResponse response = new HotelResponse("Available hotels fetched", queryParams);
 
        try {
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            return "{\"error\": \"Failed to serialize response\"}";
        }
    }
}