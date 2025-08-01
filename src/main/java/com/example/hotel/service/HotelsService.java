package com.example.hotel.service;

import com.example.hotel.model.HotelResponse;
import com.example.hotel.util.ResponseUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HotelsService {

    public Map<String, Object> getHotelsByCategoryAndRating(Map<String, String> queryParams) {
        if (queryParams == null || !queryParams.containsKey("category") || !queryParams.containsKey("minRating")) {
            return ResponseUtil.createErrorResponse(400, "Missing required query parameters: category and minRating");
        }

        String category = queryParams.get("category");
        String minRatingStr = queryParams.get("minRating");

        if (category == null || category.isBlank() || minRatingStr == null || minRatingStr.isBlank()) {
            return ResponseUtil.createErrorResponse(400, "Query parameters cannot be blank");
        }

        double minRating;
        try {
            minRating = Double.parseDouble(minRatingStr);
        } catch (NumberFormatException e) {
            return ResponseUtil.createErrorResponse(400, "minRating must be a valid number");
        }

        List<HotelResponse> filtered = StaticHotelData.getHotels().stream()
                .filter(h -> category.equalsIgnoreCase(h.category) && h.rating >= minRating)
                .collect(Collectors.toList());

        return ResponseUtil.createSuccessResponse(filtered);
    }
}