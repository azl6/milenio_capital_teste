package com.azold6.m_capital.dto;

import java.util.List;

public class GraphResponseDto {
        private Integer id;
        private List<RouteResponseDto> data;

    public GraphResponseDto(Integer id, List<RouteResponseDto> data) {
        this.id = id;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<RouteResponseDto> getData() {
        return data;
    }

    public void setData(List<RouteResponseDto> data) {
        this.data = data;
    }
}
