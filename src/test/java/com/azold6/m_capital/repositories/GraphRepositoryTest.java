package com.azold6.m_capital.repositories;

import com.azold6.m_capital.domain.Graph;
import com.azold6.m_capital.domain.Route;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class GraphRepositoryTest {

    @Autowired
    private GraphRepository graphRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByIdTest() {
        //cenário
        Graph graph = getGraph();

        //execução
        testEntityManager.persist(graph);
        Graph result = graphRepository.findById(graph.getId()).get();

        //assert
        assertEquals(graph.getId(), result.getId());
    }

    @Test
    public void saveGraphTest() {
        //cenário
        Graph graph = getGraph();

        //execução
        Graph result = graphRepository.save(graph);

        //assert
        assertThat(result.getId()).isNotNull();
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
