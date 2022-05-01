package com.azold6.m_capital.repositories;

import com.azold6.m_capital.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PathRepository extends JpaRepository<Route, Integer> {
    public List<Route> findByGraphId(Integer id);
}
