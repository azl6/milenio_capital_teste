package com.azold6.m_capital.domain;

import com.azold6.m_capital.dto.GraphResponseDto;
import com.azold6.m_capital.dto.RouteResponseDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Graph implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "graph")
    private List<Route> data;

    public Graph(List<Route> data) {
        this.data = data;
    }

    public Graph() {
    }

    public GraphResponseDto toResponseDto(){
        List<RouteResponseDto> routesDto = new ArrayList<>();
        this.getData().forEach(route -> routesDto.add(route.toResponseDto()));
        return new GraphResponseDto(this.getId(), routesDto);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Route> getData() {
        return data;
    }

    public void setData(List<Route> data) {
        this.data = data;
    }
}

