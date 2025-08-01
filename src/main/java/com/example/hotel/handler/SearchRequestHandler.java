package com.example.hotel.handler;

import com.example.hotel.service.SearchService;
import com.example.hotel.util.ResponseUtil;

import java.util.Map;
import java.util.Optional;

public class SearchRequestHandler {

    private final SearchService service = new SearchService();

    public Map<String, Object> handle(Map<String, String> queryParams) {
        try {
            //Optional used  to safely handle null queryParams
            Map<String, String> safeParams = Optional.ofNullable(queryParams)
                                                     .orElseGet(() -> Map.of());

            return Optional.ofNullable(service.searchHotelsByName(safeParams))
                           .orElseGet(() -> ResponseUtil.createErrorResponse(500, "No matching hotels found"));
        } catch (Exception e) {
            return ResponseUtil.createErrorResponse(500, "Error processing search request: " + e.getMessage());
        }
    }
}