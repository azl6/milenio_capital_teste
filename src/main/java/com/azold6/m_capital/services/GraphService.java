package com.azold6.m_capital.services;

import com.azold6.m_capital.domain.Graph;
import com.azold6.m_capital.exceptions.ObjectNotFoundException;
import com.azold6.m_capital.repositories.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GraphService {

    @Autowired
    private GraphRepository graphRepository;

    public Graph findGraphById(Integer id){
        Optional<Graph> obj = graphRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("O id do grafo informado não está cadastrado."));
    }

    public Graph saveGraph(Graph graph){
        return graphRepository.save(graph);
    }
}
