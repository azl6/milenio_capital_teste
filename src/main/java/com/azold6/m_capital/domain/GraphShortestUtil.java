package com.azold6.m_capital.domain;

import java.util.HashSet;
import java.util.Set;

public class GraphShortestUtil {

    private Set<NodeShortestUtil> nodeShortestUtils = new HashSet<>();

    public void addNode(NodeShortestUtil nodeShortestUtilA) {
        nodeShortestUtils.add(nodeShortestUtilA);
    }

    public Set<NodeShortestUtil> getNodes() {
        return nodeShortestUtils;
    }

    public void setNodes(Set<NodeShortestUtil> nodeShortestUtils) {
        this.nodeShortestUtils = nodeShortestUtils;
    }

}
