package com.azold6.m_capital.dto;

public class RouteStopsResponseDto {

    private String route;
    private Integer stops;

    public RouteStopsResponseDto() {
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Integer getStops() {
        return stops;
    }

    public void setStops(Integer stops) {
        this.stops = stops;
    }
}
