package com.azold6.m_capital.services;

import com.azold6.m_capital.domain.Route;
import com.azold6.m_capital.repositories.RouteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class RouteServiceTest {

    RouteService routeService;

    @MockBean
    RouteRepository routeRepository;

    @Test
    public void saveRouteTest(){

        //cenário
        Route route = getRoute();

        //execução
        routeRepository.save(route);
        verify(routeRepository, times(1)).save(route);
    }

    private Route getRoute(){
        return new Route("A", "B", 2);
    }
}
