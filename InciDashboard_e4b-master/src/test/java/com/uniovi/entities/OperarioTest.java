package com.uniovi.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class OperarioTest {

	@Test
	public void idEqualsTest() {
		Operario operario1 = new Operario();
		operario1.setId(1);

		Operario operario2 = new Operario();
		operario2.setId(1);

		assertEquals(operario1.getId(), operario2.getId());
	}

	@Test
	public void idDifferentTest() {
		Operario operario1 = new Operario();
		operario1.setId(1);

		Operario operario2 = new Operario();
		operario2.setId(2);

		assertNotEquals(operario1.getId(), operario2.getId());
	}

	@Test
	public void nameEqualsTest() {
		Operario operario1 = new Operario();
		operario1.setNombre("Operario");

		Operario operario2 = new Operario();
		operario2.setNombre("Operario");

		assertEquals(operario1.getNombre(), operario2.getNombre());
	}

	@Test
	public void nameDifferentTest() {
		Operario operario1 = new Operario();
		operario1.setNombre("Operario");

		Operario operario2 = new Operario();
		operario2.setNombre("OtroOperario");

		assertNotEquals(operario1.getNombre(), operario2.getNombre());
	}

	@Test
	public void dniEqualsTest() {
		Operario operario1 = new Operario();
		operario1.setDni("00000Z");

		Operario operario2 = new Operario();
		operario2.setDni("00000Z");

		assertEquals(operario1.getDni(), operario2.getDni());
	}

	@Test
	public void dniDifferentTest() {
		Operario operario1 = new Operario();
		operario1.setDni("00000Z");

		Operario operario2 = new Operario();
		operario2.setDni("11111Z");

		assertNotEquals(operario1.getDni(), operario2.getDni());
	}

	@Test
	public void incidenceEqualsTest() {
		Incidencia test = new Incidencia();
		test.setId(1L);
		List<Incidencia> lista = new ArrayList<Incidencia>();
		lista.add(test);
		
		Operario operario1 = new Operario();
		operario1.setIncidencias(lista);

		Operario operario2 = new Operario();
		operario2.setIncidencias(lista);
		
		for(int i=0;i<lista.size();i++)
			assertEquals(operario1.getIncidencias().get(i), operario2.getIncidencias().get(i));
	}

	@Test
	public void incidenceDifferentTest() {
		Incidencia test = new Incidencia();
		test.setId(1L);
		List<Incidencia> lista = new ArrayList<Incidencia>();
		lista.add(test);
		
		Incidencia test2 = new Incidencia();
		test2.setId(2L);
		List<Incidencia> lista2 = new ArrayList<Incidencia>();
		lista2.add(test2);
		
		Operario operario1 = new Operario();
		operario1.setIncidencias(lista);

		Operario operario2 = new Operario();
		operario2.setIncidencias(lista2);
		
		for(int i=0;i<lista.size();i++)
			assertNotEquals(operario1.getIncidencias().get(i), operario2.getIncidencias().get(i));
	}

	@Test
	public void passwordEqualsTest() {
		Operario operario1 = new Operario();
		operario1.setPassword("password");

		Operario operario2 = new Operario();
		operario2.setPassword("password");


		assertEquals(operario1.getPassword(), operario2.getPassword());
	}

	@Test
	public void passwordDifferentTest() {
		Operario operario1 = new Operario();
		operario1.setPassword("password");

		Operario operario2 = new Operario();
		operario2.setPassword("password2");


		assertNotEquals(operario1.getPassword(), operario2.getPassword());
	}


	@Test
	public void notificationsEqualsTest() {
		Notificacion notificacion = new Notificacion();
		notificacion.setId(1L);

		Operario operario1 = new Operario();
		operario1.getNotificaciones().add(notificacion);

		Operario operario2 = new Operario();
		operario2.getNotificaciones().add(notificacion);

		for(int i=0;i<operario1.getNotificaciones().size();i++)
			assertEquals(operario1.getNotificaciones().get(i), operario2.getNotificaciones().get(i));
	}

	@Test
	public void notificationsDifferentTest() {
		Notificacion notificacion = new Notificacion();
		notificacion.setId(1L);
		
		Notificacion notificacion2 = new Notificacion();
		notificacion2.setId(2L);

		Operario operario1 = new Operario();
		operario1.getNotificaciones().add(notificacion);

		Operario operario2 = new Operario();
		operario2.getNotificaciones().add(notificacion2);

		for(int i=0;i<operario1.getNotificaciones().size();i++)
			assertNotEquals(operario1.getNotificaciones().get(i), operario2.getNotificaciones().get(i));
	}
	
}
