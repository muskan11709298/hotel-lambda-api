package com.example.hotel;

import com.example.hotel.handler.AvailableHotelHandler;
import com.example.hotel.handler.HotelRequestHandler;
import com.example.hotel.handler.SearchRequestHandler;
import com.example.hotel.util.ResponseUtil;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;

public class Router {

    private final Map<String, Function<Map<String, String>, Map<String, Object>>> routeHandlers = new HashMap<>();

    public Router() {
        routeHandlers.put("/hotels", new HotelRequestHandler()::handle);
        routeHandlers.put("/hotels/search", new SearchRequestHandler()::handle);
        routeHandlers.put("/hotels/available", new AvailableHotelHandler()::handle);
    }

    public Map<String, Object> route(String path, Map<String, String> queryParams) {
        return Optional.ofNullable(routeHandlers.get(path))
                .map(handler -> {
                    try {
                        return handler.apply(queryParams);
                    } catch (Exception e) {
                        return ResponseUtil.createErrorResponse(500, "Handler error: " + e.getMessage());
                    }
                })
                .orElseGet(() -> ResponseUtil.createErrorResponse(404, "Path not found"));
    }
}