package com.example.hotel.handler;

import com.example.hotel.service.AvailableHotelsService;
import com.example.hotel.util.ResponseUtil;

import java.util.Map;
import java.util.Optional;

public class AvailableHotelHandler {

    private final AvailableHotelsService service = new AvailableHotelsService();

    public Map<String, Object> handle(Map<String, String> queryParams) {
        try {
            return Optional.ofNullable(service.getAvailableHotels())
                           .orElseGet(() -> ResponseUtil.createErrorResponse(500, "No data available"));
        } catch (Exception e) {
            return ResponseUtil.createErrorResponse(500, "Error fetching available hotels: " + e.getMessage());
        }
    }
}