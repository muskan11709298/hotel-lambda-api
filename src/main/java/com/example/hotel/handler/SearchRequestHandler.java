package com.example.hotel.handler;
 
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.example.hotel.service.SearchService;
 
public class SearchRequestHandler {
 
    private final SearchService searchService;
 
    public SearchRequestHandler() {
        this.searchService = new SearchService();
    }
 
    public APIGatewayProxyResponseEvent handle(APIGatewayProxyRequestEvent request) {
        String responseBody = searchService.processSearch(request);
 
        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withBody(responseBody);
    }
}
 