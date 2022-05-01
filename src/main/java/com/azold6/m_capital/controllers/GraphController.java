package com.azold6.m_capital.controllers;

import com.azold6.m_capital.domain.Graph;
import com.azold6.m_capital.services.GraphService;
import com.azold6.m_capital.services.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/graph")
public class GraphController {

    @Autowired
    private GraphService graphService;

    @Autowired
    private PathService pathService;

    @GetMapping(value = "/{graphId}")
    public ResponseEntity<Graph> findGraphById(@PathVariable Integer graphId){
        Graph obj = graphService.findGraphById(graphId);

        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @PostMapping
    public ResponseEntity<Graph> saveGraph(@RequestBody Graph graph){
        Graph obj = graphService.saveGraph(graph);
        graph.getData().forEach(path -> {
            path.setGraph(obj);
            pathService.savePath(path);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }
}
