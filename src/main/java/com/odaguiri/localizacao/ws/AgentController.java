package com.odaguiri.localizacao.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odaguiri.localizacao.service.AgentService;

@RestController
@RequestMapping(path = "/v1/agents")
public class AgentController {

	private final AgentService agentService;

	@Autowired
	public AgentController(AgentService agentService) {
		this.agentService = agentService;
	}
	
}
