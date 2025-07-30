package com.example.hotel.handler;
 
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.example.hotel.service.AvailableHotelsService;
 
public class AvailableHotelsHandler {
 
    private final AvailableHotelsService availableHotelsService;
 
    public AvailableHotelsHandler() {
        this.availableHotelsService = new AvailableHotelsService();
    }
 
    public APIGatewayProxyResponseEvent handle(APIGatewayProxyRequestEvent request) {
        String responseBody = availableHotelsService.processAvailability(request);
 
        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withBody(responseBody);
    }
}
 