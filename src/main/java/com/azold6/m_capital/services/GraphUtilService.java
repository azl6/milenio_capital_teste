package com.azold6.m_capital.services;

import com.azold6.m_capital.domain.GraphUtil;
import com.azold6.m_capital.domain.NodeUtil;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@Service
public class GraphUtilService {



    public static GraphUtil calculateShortestPathFromSource(GraphUtil graphUtil, NodeUtil source) {
        source.setDistance(0);

        Set<NodeUtil> settledNodeUtils = new HashSet<>();
        Set<NodeUtil> unsettledNodeUtils = new HashSet<>();

        unsettledNodeUtils.add(source);

        while (unsettledNodeUtils.size() != 0) {
            NodeUtil currentNodeUtil = getLowestDistanceNode(unsettledNodeUtils);
            unsettledNodeUtils.remove(currentNodeUtil);
            for (Map.Entry<NodeUtil, Integer> adjacencyPair:
                    currentNodeUtil.getAdjacentNodes().entrySet()) {
                NodeUtil adjacentNodeUtil = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodeUtils.contains(adjacentNodeUtil)) {
                    calculateMinimumDistance(adjacentNodeUtil, edgeWeight, currentNodeUtil);
                    unsettledNodeUtils.add(adjacentNodeUtil);
                }
            }
            settledNodeUtils.add(currentNodeUtil);
        }
        return graphUtil;
    }


    private static NodeUtil getLowestDistanceNode(Set <NodeUtil> unsettledNodeUtils) {
        NodeUtil lowestDistanceNodeUtil = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (NodeUtil nodeUtil : unsettledNodeUtils) {
            int nodeDistance = nodeUtil.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNodeUtil = nodeUtil;
            }
        }
        return lowestDistanceNodeUtil;
    }

    private static void calculateMinimumDistance(NodeUtil evaluationNodeUtil,
                                                 Integer edgeWeigh, NodeUtil sourceNodeUtil) {
        Integer sourceDistance = sourceNodeUtil.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNodeUtil.getDistance()) {
            evaluationNodeUtil.setDistance(sourceDistance + edgeWeigh);
            LinkedList<NodeUtil> shortestPath = new LinkedList<>(sourceNodeUtil.getShortestPath());
            shortestPath.add(sourceNodeUtil);
            evaluationNodeUtil.setShortestPath(shortestPath);
        }
    }
}
