package com.azold6.m_capital.domain;

import java.util.HashSet;
import java.util.Set;

public class GraphUtil {

    private Set<NodeUtil> nodeUtils = new HashSet<>();

    public void addNode(NodeUtil nodeUtilA) {
        nodeUtils.add(nodeUtilA);
    }

    public Set<NodeUtil> getNodes() {
        return nodeUtils;
    }

    public void setNodes(Set<NodeUtil> nodeUtils) {
        this.nodeUtils = nodeUtils;
    }

}
