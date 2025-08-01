package com.example.hotel.service;

import com.example.hotel.model.HotelResponse;
import com.example.hotel.util.ResponseUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AvailableHotelsService {

    public Map<String, Object> getAvailableHotels() {
        try {
            //Optional used to safely handle  null from data source
            List<HotelResponse> availableHotels = Optional.ofNullable(StaticHotelData.getHotels())
                    .orElseGet(List::of) // fallback to empty list
                    .stream()
                    .filter(HotelResponse::isAvailable)
                    .collect(Collectors.toList());

            return ResponseUtil.createSuccessResponse(availableHotels);
        } catch (Exception e) {
            return ResponseUtil.createErrorResponse(500, "Error retrieving available hotels: " + e.getMessage());
        }
    }
}