package com.azold6.m_capital.services;

import com.azold6.m_capital.domain.Path;
import com.azold6.m_capital.repositories.PathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PathService {

    @Autowired
    private PathRepository pathRepository;

    public Path savePath(Path path){
        //validar se existe
        return pathRepository.save(path);
    }
}
