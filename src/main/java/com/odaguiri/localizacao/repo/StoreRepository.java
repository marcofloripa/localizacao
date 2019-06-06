package com.odaguiri.localizacao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odaguiri.localizacao.domain.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}
