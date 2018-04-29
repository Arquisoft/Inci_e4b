package com.uniovi.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class FiltroTest {

	@Test
	public void idEqualsTest() {
		FiltroPropiedades filtro1 = new FiltroPropiedades();
		filtro1.setId(1L);
		
		FiltroPropiedades filtro2 = new FiltroPropiedades();
		filtro2.setId(1L);
		
		assertEquals(filtro1.getId(), filtro2.getId());
	}
	
	@Test
	public void idDifferentTest() {
		FiltroPropiedades filtro1 = new FiltroPropiedades();
		filtro1.setId(1L);
		
		FiltroPropiedades filtro2 = new FiltroPropiedades();
		filtro2.setId(2L);
		
		assertNotEquals(filtro1.getId(), filtro2.getId());
	}
	
	@Test
	public void fieldNameEqualsTest() {
		FiltroPropiedades filtro1 = new FiltroPropiedades();
		filtro1.setFieldName("filtro");
		
		FiltroPropiedades filtro2 = new FiltroPropiedades();
		filtro2.setFieldName("filtro");
		
		assertEquals(filtro1.getFieldName(), filtro2.getFieldName());
	}

	@Test
	public void fieldNameDifferentTest() {
		FiltroPropiedades filtro1 = new FiltroPropiedades();
		filtro1.setFieldName("filtro");
		
		FiltroPropiedades filtro2 = new FiltroPropiedades();
		filtro2.setFieldName("filtro2");
		
		assertNotEquals(filtro1.getFieldName(), filtro2.getFieldName());
	}
	
	@Test
	public void valueEqualsTest() {
		FiltroPropiedades filtro1 = new FiltroPropiedades();
		filtro1.setValue("3");
		
		FiltroPropiedades filtro2 = new FiltroPropiedades();
		filtro2.setValue("3");
		
		assertEquals(filtro1.getValue(), filtro2.getValue());
	}
	
	@Test
	public void valueDifferentTest() {
		FiltroPropiedades filtro1 = new FiltroPropiedades();
		filtro1.setValue("3");
		
		FiltroPropiedades filtro2 = new FiltroPropiedades();
		filtro2.setValue("2");
		
		assertNotEquals(filtro1.getValue(), filtro2.getValue());
	}
	
	@Test
	public void operationEqualsTest() {
		FiltroPropiedades filtro1 = new FiltroPropiedades();
		filtro1.setOperation(0);
		
		FiltroPropiedades filtro2 = new FiltroPropiedades();
		filtro2.setOperation(0);
		
		assertEquals(filtro1.getOperation(), filtro2.getOperation());
	}
	
	@Test
	public void operationDifferentTest() {
		FiltroPropiedades filtro1 = new FiltroPropiedades();
		filtro1.setOperation(0);
		
		FiltroPropiedades filtro2 = new FiltroPropiedades();
		filtro2.setOperation(1);
		
		assertNotEquals(filtro1.getOperation(), filtro2.getOperation());
	}
	
	@Test
	public void operarioEqualsTest() {
		Operario operario = new Operario();
		
		FiltroPropiedades filtro1 = new FiltroPropiedades();
		filtro1.setOperario(operario);
		
		FiltroPropiedades filtro2 = new FiltroPropiedades();
		filtro2.setOperario(operario);
		
		assertEquals(filtro1.getOperario(), filtro2.getOperario());
	}
	
	@Test
	public void operarioDifferentTest() {
		Operario operario1 = new Operario();
		operario1.setId(1L);
		
		Operario operario2 = new Operario();
		operario1.setId(2L);
		
		FiltroPropiedades filtro1 = new FiltroPropiedades();
		filtro1.setOperario(operario1);
		
		FiltroPropiedades filtro2 = new FiltroPropiedades();
		filtro2.setOperario(operario2);
		
		assertNotEquals(filtro1.getOperario(), filtro2.getOperario());
	}
	
}
