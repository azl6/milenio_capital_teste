package com.azold6.m_capital.services;

import com.azold6.m_capital.domain.Route;
import com.azold6.m_capital.repositories.PathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PathService {

    @Autowired
    private PathRepository pathRepository;

    public Route savePath(Route route){
        //validar se existe
        return pathRepository.save(route);
    }
}
