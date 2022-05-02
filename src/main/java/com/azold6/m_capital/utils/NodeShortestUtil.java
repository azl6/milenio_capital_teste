package com.azold6.m_capital.utils;

import java.util.*;

public class NodeShortestUtil {

    private String name;

    private List<NodeShortestUtil> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    Map<NodeShortestUtil, Integer> adjacentNodes = new HashMap<>();

    private GraphShortestUtil graphShortestUtil;

    public NodeShortestUtil() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", shortestPath=" + shortestPath +
                ", distance=" + distance +
                '}';
    }

    public void addDestination(NodeShortestUtil destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public NodeShortestUtil(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NodeShortestUtil> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<NodeShortestUtil> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<NodeShortestUtil, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<NodeShortestUtil, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}