package com.example.hotel.handler;
 
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.example.hotel.service.HotelService;
 
public class HotelRequestHandler {
 
    private final HotelService hotelService;
 
    // Default constructor for Lambda
    public HotelRequestHandler() {
        this.hotelService = new HotelService();
    }
 
    public APIGatewayProxyResponseEvent handle(APIGatewayProxyRequestEvent request) {
        String responseBody = hotelService.processHotelRequest(request);
 
        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withBody(responseBody);
    }
}
