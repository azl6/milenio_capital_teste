package com.azold6.m_capital.dto;

import java.util.List;

public class RoutesResponseDto {

    private List<RouteStopsResponseDto> routes;

    public RoutesResponseDto() {
    }

    public List<RouteStopsResponseDto> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteStopsResponseDto> routes) {
        this.routes = routes;
    }
}
