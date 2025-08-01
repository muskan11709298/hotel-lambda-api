package com.example.hotel.service;

import com.example.hotel.model.HotelResponse;
import com.example.hotel.util.ResponseUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchService {

    public Map<String, Object> searchHotelsByName(Map<String, String> queryParams) {
        try {
            // Safely extract 'name' parameter using Optional
            String name = Optional.ofNullable(queryParams)
                                  .map(params -> params.get("name"))
                                  .filter(n -> !n.isBlank())
                                  .orElseThrow(() -> new IllegalArgumentException("Missing or blank 'name' parameter"));

            // Filter hotels by name (case-insensitive)
            List<HotelResponse> filtered = Optional.ofNullable(StaticHotelData.getHotels())
                    .orElseGet(List::of)
                    .stream()
                    .filter(hotel -> hotel.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());

            return ResponseUtil.createSuccessResponse(filtered);

        } catch (IllegalArgumentException e) {
            return ResponseUtil.createErrorResponse(400, e.getMessage());

        } catch (Exception e) {
            return ResponseUtil.createErrorResponse(500, "Error searching hotels: " + e.getMessage());
        }
    }
}