package com.azold6.m_capital.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Graph {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "graph")
    private List<Path> paths;

    public Graph(List<Path> paths) {
        this.paths = paths;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }
}
