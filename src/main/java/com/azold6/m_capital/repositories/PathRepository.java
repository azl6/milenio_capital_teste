package com.azold6.m_capital.repositories;

import com.azold6.m_capital.domain.Graph;
import com.azold6.m_capital.domain.Path;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PathRepository extends JpaRepository<Path, Integer> {
    public List<Path> findByGraphId(Integer id);
}
