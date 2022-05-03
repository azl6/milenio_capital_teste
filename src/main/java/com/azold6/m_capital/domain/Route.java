package com.azold6.m_capital.domain;

import com.azold6.m_capital.dto.RouteResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Route implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String source;
    private String target;
    private Integer distance;

    @ManyToOne
    @JoinColumn(name = "graph_id")
    private Graph graph;

    public Route(String source, String target, Integer distance) {
        this.source = source;
        this.target = target;
        this.distance = distance;
    }

    public Route() {
    }

    public RouteResponseDto toResponseDto(){
        return new RouteResponseDto(this.source, this.getTarget(), this.getDistance());
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
