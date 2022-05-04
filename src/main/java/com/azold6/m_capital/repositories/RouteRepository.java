package com.azold6.m_capital.repositories;

import com.azold6.m_capital.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Integer> {
    boolean existsByGraphIdAndSourceAndTargetAndDistance(Integer graphId, String source, String target, Integer distance);
}
