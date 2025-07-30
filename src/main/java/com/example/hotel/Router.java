package com.example.hotel;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.example.hotel.handler.*;
 
//decides which handler to call based on path
public class Router {
 
    public APIGatewayProxyResponseEvent routeRequest(String path, APIGatewayProxyRequestEvent request) {
        switch (path) {
          //calls hotelRequestHandler
            case "/hotels":
                return new HotelRequestHandler().handle(request);
     
           //calls SearchRequestHandler
            case "/hotels/search":
                return new SearchRequestHandler().handle(request);
 
          //calls AvailableHotelsHandler
            case "/hotels/available":
                return new AvailableHotelsHandler().handle(request);
 
            default:
                return new APIGatewayProxyResponseEvent()
                        .withStatusCode(404)
                        .withBody("{\"error\": \"Invalid path\"}");
        }
    }
}