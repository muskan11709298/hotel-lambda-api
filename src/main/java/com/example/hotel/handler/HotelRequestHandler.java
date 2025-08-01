package com.example.hotel.handler;

import com.example.hotel.service.HotelsService;
import com.example.hotel.util.ResponseUtil;

import java.util.Map;
import java.util.Optional;

public class HotelRequestHandler {

    private final HotelsService service = new HotelsService();

    public Map<String, Object> handle(Map<String, String> queryParams) {
        try {
            //Optional used  to safely handle null queryParams
            Map<String, String> safeParams = Optional.ofNullable(queryParams)
                                                     .orElseGet(() -> Map.of());

            return Optional.ofNullable(service.getHotelsByCategoryAndRating(safeParams))
                           .orElseGet(() -> ResponseUtil.createErrorResponse(500, "No hotel data found"));
        } catch (Exception e) {
            return ResponseUtil.createErrorResponse(500, "Error processing hotel request: " + e.getMessage());
        }
    }
}