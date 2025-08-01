package com.example.hotel.service;

import com.example.hotel.model.HotelResponse;

import java.util.List;

public class StaticHotelData {

    public static List<HotelResponse> getHotels() {
        return List.of(
            new HotelResponse(1, "Royal Palace", "LUXURY", 4.8, true),
            new HotelResponse(2, "Budget Inn", "BUDGET", 3.9, false),
            new HotelResponse(3, "Elite Stay", "LUXURY", 4.6, true),
            new HotelResponse(4, "Comfort Suites", "MIDRANGE", 4.2, true)
        );
    }
}