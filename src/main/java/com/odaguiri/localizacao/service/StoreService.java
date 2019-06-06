package com.odaguiri.localizacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odaguiri.localizacao.domain.Store;
import com.odaguiri.localizacao.repo.StoreRepository;

@Service
public class StoreService {

	private final StoreRepository storeRepository;
	
	@Autowired
	public StoreService(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}

	public List<Store> findAll() {
		return storeRepository.findAll(); 
	}
}
