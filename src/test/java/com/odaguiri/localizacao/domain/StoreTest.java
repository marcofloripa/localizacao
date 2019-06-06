package com.odaguiri.localizacao.domain;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

public class StoreTest {
	
	private static Store angeloniCapoeiras;
	private static Store angeloniJardimAtlantico;
	
	@BeforeClass
	public static void init() {
		angeloniCapoeiras = new Store(1l, "Angeloni", null);
		angeloniJardimAtlantico = new Store(1l, "Angeloni", null);
	}

	@Test
	public void testBuilder() {
		Store store = Store.builder()
				.id(1l)
				.name("Angeloni")
				.build();
		assertThat(store.getId(), is(1l));
		assertThat(store.getName(), is("Angeloni"));
	}
	
	@Test
	public void testConstructorAllArgs() {
		Store store = new Store(1l, "Havan", null);
		assertThat(store.getId(), is(1l));
		assertThat(store.getName(), is("Havan"));
		assertThat(store.getAddress(), is(nullValue()));
	}
	
	@Test
	public void tesEquals() {
		assertThat(angeloniCapoeiras, is(angeloniJardimAtlantico));
	}
	
	@Test
	public void testEqualsForSetContains() {
		Set<Store> stores = new HashSet<>();
		stores.add(angeloniCapoeiras);
		stores.add(angeloniJardimAtlantico);
		assertThat(1, is(stores.size()));
	}
	
	@Test
	public void testHashcode() {
		assertThat(angeloniCapoeiras.hashCode(), is(angeloniJardimAtlantico.hashCode()));
	}
	
}
