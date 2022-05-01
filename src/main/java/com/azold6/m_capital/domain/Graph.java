package com.azold6.m_capital.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Graph {

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

