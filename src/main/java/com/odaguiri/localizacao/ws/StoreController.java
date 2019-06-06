package com.odaguiri.localizacao.ws;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odaguiri.localizacao.domain.Store;
import com.odaguiri.localizacao.service.StoreService;

@RestController
@RequestMapping(path = "/v1/stores")
public class StoreController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

	private final StoreService storeService;
	
	@Autowired
	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}
	
	@GetMapping
	public List<Store> getAllStores() {
		LOGGER.info("GET /v1/stores");
		return storeService.findAll();
	}
}
