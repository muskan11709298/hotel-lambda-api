package com.example.hotel.model;
 
public class HotelResponse {
    private String message;
    private Object data;
 
    public HotelResponse() {}
 
    public HotelResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }
 
    public String getMessage() {
        return message;
    }
 
    public Object getData() {
        return data;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public void setData(Object data) {
        this.data = data;
    }
}
 