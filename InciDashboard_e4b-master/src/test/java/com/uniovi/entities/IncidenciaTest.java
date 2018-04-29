package com.uniovi.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.uniovi.entities.extras.Location;
import com.uniovi.entities.extras.Status;

public class IncidenciaTest {

	@Test
	public void idEqualsTest() {
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setId(1L);
		
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setId(1L);
		
		assertEquals(incidencia1.getId(), incidencia2.getId());
	}

	@Test
	public void idNotEqualsTest() {
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setId(1L);
		
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setId(2L);
		
		assertNotEquals(incidencia1.getId(), incidencia2.getId());
	}
	
	@Test
	public void incidenceNameEqualsTest() {
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setIncidenceName("test");

		Incidencia incidencia2 = new Incidencia();
		incidencia2.setIncidenceName("test");
		
		assertEquals(incidencia1.getIncidenceName(), incidencia2.getIncidenceName());
	}
	
	@Test
	public void incidenceNameDifferentTest() {
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setIncidenceName("test");

		Incidencia incidencia2 = new Incidencia();
		incidencia2.setIncidenceName("test2");
		
		assertNotEquals(incidencia1.getIncidenceName(), incidencia2.getIncidenceName());
	}
	
	@Test
	public void descriptionEqualsTest() {
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setDescription("test");

		Incidencia incidencia2 = new Incidencia();
		incidencia2.setDescription("test");
		
		assertEquals(incidencia1.getDescription(), incidencia2.getDescription());
	}
	
	@Test
	public void descriptionDifferentTest() {
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setDescription("test");

		Incidencia incidencia2 = new Incidencia();
		incidencia2.setDescription("test2");
		
		assertNotEquals(incidencia1.getDescription(), incidencia2.getDescription());
	}
	
	@Test
	public void locationEqualsTest() {
		Location location = new Location(0,0);
		
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setLocation(location);
	
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setLocation(location);
		
		assertEquals(incidencia1.getLocation(), incidencia2.getLocation());
	}
	
	@Test
	public void locationDifferentTest() {
		Location location1 = new Location(0,0);
		Location location2 = new Location(1,1);
		
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setLocation(location1);
	
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setLocation(location2);
		
		assertNotEquals(incidencia1.getLocation(), incidencia2.getLocation());
	}
	
	@Test
	public void tagsEqualsTest() {
		ArrayList<String> test = new ArrayList<String>();
		test.add("test");
		
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setTags(test);
		
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setTags(test);
		
		for(int i=0;i<incidencia1.getTags().size();i++)
			assertEquals(incidencia1.getTags().get(i), incidencia2.getTags().get(i));
	}
	
	@Test
	public void tagsDifferentTest() {
		ArrayList<String> test1 = new ArrayList<String>();
		test1.add("test1");
		
		ArrayList<String> test2 = new ArrayList<String>();
		test2.add("test2");
		
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setTags(test1);
		
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setTags(test2);
		
		for(int i=0;i<incidencia1.getTags().size();i++)
			assertNotEquals(incidencia1.getTags().get(i), incidencia2.getTags().get(i));
	}
	
	@Test
	public void fieldsEqualsTest() {
		Map<String,String> test = new HashMap<String,String>();
		test.put("Temperatura", "30");
		
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setFields(test);
		
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setFields(test);
		
		for(String key : test.keySet())
			assertEquals(incidencia1.getFields().get(key), incidencia2.getFields().get(key));
	}
	
	@Test
	public void fieldsDifferentTest() {
		Map<String,String> test1 = new HashMap<String,String>();
		test1.put("Temperatura", "30");
		
		Map<String,String> test2 = new HashMap<String,String>();
		test2.put("Temperatura", "40");
		
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setFields(test1);
		
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setFields(test2);
		
		for(String key : test1.keySet())
			assertNotEquals(incidencia1.getFields().get(key), incidencia2.getFields().get(key));
	}
	
	@Test
	public void statusEqualsTest() {
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setStatus(Status.ABIERTA);
		
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setStatus(Status.ABIERTA);
		
		assertEquals(incidencia1.getStatus(), incidencia2.getStatus());
	}
	
	@Test
	public void statusDifferentTest() {
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setStatus(Status.ABIERTA);
		
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setStatus(Status.CERRADA);
		
		assertNotEquals(incidencia1.getStatus(), incidencia2.getStatus());
	}
	
	@Test
	public void commentsEqualsTest() {
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setComments("test");
		
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setComments("test");
		
		assertEquals(incidencia1.getComments(), incidencia2.getComments());
	}
	
	@Test
	public void commentsDifferentTest() {
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setComments("test1");
		
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setComments("test2");
		
		assertNotEquals(incidencia1.getComments(), incidencia2.getComments());
	}
	
	@Test
	public void expirationDateEqualsTest() {
		Date date = new Date();
		date.setTime(0);
		
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setExpirationDate(date);
		
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setExpirationDate(date);
		
		assertEquals(incidencia1.getExpirationDate(), incidencia2.getExpirationDate());
	}
	
	@Test
	public void expirationDateDifferentTest() {
		Date date1 = new Date();
		date1.setTime(0);
		
		Date date2 = new Date();
		date2.setTime(1234);
		
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setExpirationDate(date1);
		
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setExpirationDate(date2);
		
		assertNotEquals(incidencia1.getExpirationDate(), incidencia2.getExpirationDate());
	}
	
	@Test
	public void operarioEqualsTest() {
		Operario operario = new Operario();
		operario.setId(1L);
		
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setOperario(operario);
		
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setOperario(operario);
		
		assertEquals(incidencia1.getOperario(), incidencia2.getOperario());
	}
	
	@Test
	public void operarioDifferentTest() {
		Operario operario1 = new Operario();
		operario1.setId(1L);
		
		Operario operario2 = new Operario();
		operario2.setId(2L);
		
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setOperario(operario1);
		
		Incidencia incidencia2 = new Incidencia();
		incidencia2.setOperario(operario2);
		
		assertNotEquals(incidencia1.getOperario(), incidencia2.getOperario());
	}
	
}
