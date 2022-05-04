package com.azold6.m_capital.services;

import com.azold6.m_capital.domain.Route;
import com.azold6.m_capital.exceptions.ExistentPathException;
import com.azold6.m_capital.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;


    public Route saveRoute(Route route){
            boolean routeExists = routeRepository.existsByGraphIdAndSourceAndTargetAndDistance(
                    route.getGraph().getId(), route.getSource(), route.getTarget(), route.getDistance());

            if(routeExists) {
                throw new ExistentPathException(
                        String.format("A rota [source=%s, target=%s, distance=%d] está duplicada.",
                                route.getSource(), route.getTarget(), route.getDistance()));
            }


        return routeRepository.save(route);
    }
}
