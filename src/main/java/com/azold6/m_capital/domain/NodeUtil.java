package com.azold6.m_capital.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NodeUtil {

    private String name;

    private List<NodeUtil> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    Map<NodeUtil, Integer> adjacentNodes = new HashMap<>();

    private GraphUtil graphUtil;

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", shortestPath=" + shortestPath +
                ", distance=" + distance +
                '}';
    }

    public void addDestination(NodeUtil destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public NodeUtil(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NodeUtil> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<NodeUtil> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<NodeUtil, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<NodeUtil, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}