package com.azold6.m_capital.services;

import com.azold6.m_capital.domain.GraphShortestUtil;
import com.azold6.m_capital.domain.NodeShortestUtil;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@Service
public class GraphUtilService {

    public static GraphShortestUtil calculateShortestPathFromSource(GraphShortestUtil graphShortestUtil, NodeShortestUtil source) {
        source.setDistance(0);

        Set<NodeShortestUtil> settledNodeShortestUtils = new HashSet<>();
        Set<NodeShortestUtil> unsettledNodeShortestUtils = new HashSet<>();

        unsettledNodeShortestUtils.add(source);

        while (unsettledNodeShortestUtils.size() != 0) {
            NodeShortestUtil currentNodeShortestUtil = getLowestDistanceNode(unsettledNodeShortestUtils);
            unsettledNodeShortestUtils.remove(currentNodeShortestUtil);
            for (Map.Entry<NodeShortestUtil, Integer> adjacencyPair:
                    currentNodeShortestUtil.getAdjacentNodes().entrySet()) {
                NodeShortestUtil adjacentNodeShortestUtil = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodeShortestUtils.contains(adjacentNodeShortestUtil)) {
                    calculateMinimumDistance(adjacentNodeShortestUtil, edgeWeight, currentNodeShortestUtil);
                    unsettledNodeShortestUtils.add(adjacentNodeShortestUtil);
                }
            }
            settledNodeShortestUtils.add(currentNodeShortestUtil);
        }
        return graphShortestUtil;
    }


    private static NodeShortestUtil getLowestDistanceNode(Set <NodeShortestUtil> unsettledNodeShortestUtils) {
        NodeShortestUtil lowestDistanceNodeShortestUtil = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (NodeShortestUtil nodeShortestUtil : unsettledNodeShortestUtils) {
            int nodeDistance = nodeShortestUtil.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNodeShortestUtil = nodeShortestUtil;
            }
        }
        return lowestDistanceNodeShortestUtil;
    }

    private static void calculateMinimumDistance(NodeShortestUtil evaluationNodeShortestUtil,
                                                 Integer edgeWeigh, NodeShortestUtil sourceNodeShortestUtil) {
        Integer sourceDistance = sourceNodeShortestUtil.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNodeShortestUtil.getDistance()) {
            evaluationNodeShortestUtil.setDistance(sourceDistance + edgeWeigh);
            LinkedList<NodeShortestUtil> shortestPath = new LinkedList<>(sourceNodeShortestUtil.getShortestPath());
            shortestPath.add(sourceNodeShortestUtil);
            evaluationNodeShortestUtil.setShortestPath(shortestPath);
        }
    }
}
