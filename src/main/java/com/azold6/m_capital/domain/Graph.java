package com.azold6.m_capital.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Graph {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "graph")
    private List<Path> data;

    public Graph(List<Path> data) {
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

    public List<Path> getData() {
        return data;
    }

    public void setData(List<Path> data) {
        this.data = data;
    }
}

