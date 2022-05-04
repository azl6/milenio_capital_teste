package com.azold6.m_capital.services;

import com.azold6.m_capital.domain.Graph;
import com.azold6.m_capital.domain.Route;
import com.azold6.m_capital.repositories.GraphRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class GraphServiceTest {

    GraphService graphService;

    @MockBean
    GraphRepository graphRepository;

    @Test
    public void saveGraphTest(){

        //cenário
        Graph graph = getGraph();

        //execução
        graphRepository.save(graph);
        verify(graphRepository, times(1)).save(graph);
    }

    private Graph getGraph() {
        Graph graph = new Graph();
        graph.setId(null);
        graph.setData(getRoutes());

        return graph;
    }

    private List<Route> getRoutes(){
        Route route1 = new Route("A", "B", 2);
        Route route2 = new Route("A", "C", 3);
        Route route3 = new Route("B", "C", 5);
        return Arrays.asList(route1, route2, route3);
    }
}
