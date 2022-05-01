package com.azold6.m_capital.controllers;

import com.azold6.m_capital.domain.Graph;
import com.azold6.m_capital.domain.GraphShortestUtil;
import com.azold6.m_capital.domain.NodeShortestUtil;
import com.azold6.m_capital.services.GraphService;
import com.azold6.m_capital.services.GraphUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/distance")
public class DistanceController {

    @Autowired
    private GraphService graphService;

    @Autowired
    private GraphUtilService graphUtilService;

    @PostMapping("/{graphId}/from/{town1}/to/{town2}")
    public ResponseEntity<String> findShortestPathBetweenTwoCities(@PathVariable Integer graphId,
                                                                   @PathVariable String town1,
                                                                   @PathVariable String town2){

        Graph graph = graphService.findGraphById(graphId);

        //distinct by attribute
        List<NodeShortestUtil> nodeList = new ArrayList<>(graph.getData().stream().map(path -> {
            return new NodeShortestUtil(path.getSource());
        }).collect(Collectors.toMap(NodeShortestUtil::getName, p -> p, (p, q) -> p, LinkedHashMap::new)).values());

        nodeList.forEach(node -> {
            String source = node.getName();
            graph.getData().forEach(path -> {

                if(path.getSource().equals(source)){
                    String target = path.getTarget();

                    for (NodeShortestUtil nodeShortestUtil : nodeList) {
                        if (nodeShortestUtil.getName().equals(target))
                            node.addDestination(nodeShortestUtil, nodeShortestUtil.getDistance());
                    }
                }
                    node.addDestination(new NodeShortestUtil(path.getTarget()), path.getDistance());

                }
            );
        });

        GraphShortestUtil graphShortestUtil = new GraphShortestUtil();
        NodeShortestUtil sourceNode = new NodeShortestUtil();
        for (NodeShortestUtil nodeShortestUtil : nodeList) {
            System.out.println(nodeShortestUtil);
            graphShortestUtil.addNode(nodeShortestUtil);
            if(town1.equals(nodeShortestUtil.getName()))
                sourceNode = nodeShortestUtil;
        }

        //graphShortestUtil = graphUtilService.calculateShortestPathFromSource(graphShortestUtil, sourceNode);
        //PROBLEMA NO DISTANCE E NA LINHA ACIMA


        return ResponseEntity.ok().body("It worked out!");
    }
}
