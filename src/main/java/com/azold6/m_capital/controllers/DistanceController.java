package com.azold6.m_capital.controllers;

import com.azold6.m_capital.domain.Graph;
import com.azold6.m_capital.domain.GraphShortestUtil;
import com.azold6.m_capital.domain.NodeShortestUtil;
import com.azold6.m_capital.domain.Route;
import com.azold6.m_capital.dto.DistanceRouteResponseDto;
import com.azold6.m_capital.services.GraphService;
import com.azold6.m_capital.services.GraphUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Node;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/distance")
public class DistanceController {

    @Autowired
    private GraphService graphService;

    @Autowired
    private GraphUtilService graphUtilService;

    @PostMapping("/{graphId}/from/{source}/to/{target}")
    public ResponseEntity<DistanceRouteResponseDto> findShortestPathBetweenTwoCities(@PathVariable Integer graphId,
                                                                   @PathVariable String source,
                                                                   @PathVariable String target){

        //buscando pelo grafo salvo
        Graph graph = graphService.findGraphById(graphId);

        //criando uma lista de nodes (vértices) do grafo
        List<NodeShortestUtil> nodeList = new ArrayList<>();

        //percorrendo as rotas do grafo e criando nodes
        for(Route route: graph.getData()){
            NodeShortestUtil nodeSource = new NodeShortestUtil(route.getSource());
            NodeShortestUtil nodeTarget = new NodeShortestUtil(route.getTarget());
            
            nodeList.addAll(Arrays.asList(nodeTarget, nodeSource));
        };

        //filtrando os nodes para serem únicos
        nodeList = nodeList.stream().filter(distinctByKey(NodeShortestUtil::getName)).collect(Collectors.toList());

        //percorrendo cada node e criando seus caminhos
        for(NodeShortestUtil node: nodeList){
            for(Route route: graph.getData()){
                if(route.getSource().equals(node.getName())){
                    for(NodeShortestUtil targetNode: nodeList){ //trocar
                        if(targetNode.getName().equals(route.getTarget())){
                            node.addDestination(targetNode, route.getDistance());
                        }
                    }
                }};
        };

        //adicionando os nodes direcionados ao grafo
        GraphShortestUtil graphShortestUtil = new GraphShortestUtil();
        for(NodeShortestUtil node: nodeList){
            graphShortestUtil.addNode(node);
        }

        //encontrando o node da cidade de origem
        NodeShortestUtil sourceNode = nodeList
                .stream()
                .filter(x -> x.getName().equals(source)).collect(Collectors.toList()).get(0);


        //PRINT DOS NODES ADJACENTES
//        nodeList.forEach(node -> {
//            System.out.println("\nNodes adjacentes a " + node.getName() + ":");
//            for (Map.Entry entry : node.getAdjacentNodes().entrySet()) {
//                System.out.println("Node: " + entry.getKey() + "; Distância: " + entry.getValue());
//            }
//        });

        //calculando os menores caminhos a partir do source passado como pathvariable
        graphShortestUtil = graphUtilService.calculateShortestPathFromSource(graphShortestUtil, sourceNode);

        DistanceRouteResponseDto obj = new DistanceRouteResponseDto();
        graphShortestUtil.getNodes().forEach(x -> {
            String distance = String.valueOf(x.getDistance());

            if(x.getShortestPath().isEmpty() || !x.getName().equals(target))
                return;

            List<String> path = new ArrayList<>();
            x.getShortestPath().forEach(nodeShortestUtil -> path.add(nodeShortestUtil.getName()));

            obj.setDistance(Integer.valueOf(distance));
            obj.setPath(path);
        });


        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
