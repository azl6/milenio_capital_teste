package com.azold6.m_capital.dto;

import java.util.ArrayList;
import java.util.List;

public class DistanceRouteResponseDto {

    private Integer distance;
    private List<String> path = new ArrayList<>();

    public DistanceRouteResponseDto(Integer distance, List<String> path) {
        this.distance = distance;
        this.path = path;
    }

    public DistanceRouteResponseDto() {
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }
}
