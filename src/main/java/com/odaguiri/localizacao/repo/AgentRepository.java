package com.odaguiri.localizacao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odaguiri.localizacao.domain.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

}
