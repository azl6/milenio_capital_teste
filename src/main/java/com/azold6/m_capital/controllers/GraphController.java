package com.azold6.m_capital.controllers;

import com.azold6.m_capital.domain.Graph;
import com.azold6.m_capital.services.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/graph")
public class GraphController {

    @Autowired
    private GraphService graphService;

    @GetMapping(value = "/{graphId}")
    public ResponseEntity<Graph> findGraphById(@PathVariable Integer graphId){
        Graph obj = graphService.findGraphById(graphId);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }
}
