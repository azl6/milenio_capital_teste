package com.azold6.m_capital.repositories;

import com.azold6.m_capital.domain.Graph;
import com.azold6.m_capital.domain.Route;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RouteRepositoryTest {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void saveRouteTest() {
        //cenário
         Route route = getRoute();

        //execução
        Route result = routeRepository.save(route);

        //assert
        assertThat(result.getId()).isNotNull();
    }

    private Route getRoute(){
        return new Route("A", "B", 2);
    }
}