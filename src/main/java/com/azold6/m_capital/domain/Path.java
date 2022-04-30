package com.azold6.m_capital.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Path {

    @JsonIgnore //retirar posteriormente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String source;
    private String target;
    private Integer distance;

    @JsonIgnore //retirar posteriormente
    @ManyToOne
    @JoinColumn(name = "graph_id")
    private Graph graph;

    public Path(String source, String target, Integer distance) {
        this.source = source;
        this.target = target;
        this.distance = distance;
    }

    public Path() {
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
