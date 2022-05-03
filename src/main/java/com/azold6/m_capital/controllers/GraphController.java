package com.azold6.m_capital.controllers;

import com.azold6.m_capital.domain.Graph;
import com.azold6.m_capital.dto.GraphResponseDto;
import com.azold6.m_capital.services.GraphService;
import com.azold6.m_capital.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/graph")
public class GraphController {

    private GraphService graphService;
    private RouteService routeService;

    public GraphController(GraphService graphService, RouteService routeService){
        this.graphService = graphService;
        this.routeService = routeService;
    }

    @GetMapping("/{graphId}")
    public ResponseEntity<GraphResponseDto> findGraphById(@PathVariable Integer graphId){
        Graph obj = graphService.findGraphById(graphId);

        return ResponseEntity.status(HttpStatus.OK).body(obj.toResponseDto());
    }

    @PostMapping
    public ResponseEntity<GraphResponseDto> saveGraph(@RequestBody Graph graph){
        Graph obj = graphService.saveGraph(graph);
        graph.getData().forEach(path -> {
            path.setGraph(obj);
            routeService.saveRoute(path);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body(obj.toResponseDto());
    }
}
