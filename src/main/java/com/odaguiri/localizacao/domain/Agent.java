package com.odaguiri.localizacao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Agent {

	@Id
	private Long id;
	
	@Column
	private String name;
	
	@ManyToOne
	private Address address;
}
