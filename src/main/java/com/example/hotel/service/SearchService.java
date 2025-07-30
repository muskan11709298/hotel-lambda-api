package com.example.hotel.service;
 
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.example.hotel.model.HotelResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
 
public class SearchService {
 
    private final ObjectMapper objectMapper = new ObjectMapper();
 
    public String processSearch(APIGatewayProxyRequestEvent request) {
        String queryParams = request.getQueryStringParameters().toString();
        HotelResponse response = new HotelResponse("Search completed", queryParams);
 
        try {
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            return "{\"error\": \"Failed to serialize response\"}";
        }
    }
}