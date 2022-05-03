package com.azold6.m_capital.services;

import com.azold6.m_capital.domain.Route;
import com.azold6.m_capital.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public Route saveRoute(Route route){
        return routeRepository.save(route);
    }
}
