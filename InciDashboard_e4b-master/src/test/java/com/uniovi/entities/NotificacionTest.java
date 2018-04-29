package com.uniovi.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class NotificacionTest {

	@Test
	public void idEqualsTest() {
		Notificacion notificacion1 = new Notificacion();
		notificacion1.setId(1L);
		
		Notificacion notificacion2 = new Notificacion();
		notificacion2.setId(1L);
		
		assertEquals(notificacion1.getId(), notificacion2.getId());
	}
	
	@Test
	public void idDifferentTest() {
		Notificacion notificacion1 = new Notificacion();
		notificacion1.setId(1L);
		
		Notificacion notificacion2 = new Notificacion();
		notificacion2.setId(2L);
		
		assertNotEquals(notificacion1.getId(), notificacion2.getId());
	}
	
	@Test
	public void operarioEqualsTest() {
		Operario operario = new Operario();
		operario.setId(1L);
		
		Notificacion notificacion1 = new Notificacion();
		notificacion1.setOperario(operario);
		
		Notificacion notificacion2 = new Notificacion();
		notificacion2.setOperario(operario);
		
		assertEquals(notificacion1.getOperario(), notificacion2.getOperario());
	}
	
	@Test
	public void operarioDifferentTest() {
		Operario operario1 = new Operario();
		operario1.setId(1L);
		
		Operario operario2 = new Operario();
		operario2.setId(2L);
		
		Notificacion notificacion1 = new Notificacion();
		notificacion1.setOperario(operario1);
		
		Notificacion notificacion2 = new Notificacion();
		notificacion2.setOperario(operario2);
		
		assertNotEquals(notificacion1.getOperario(), notificacion2.getOperario());
	}
	
	@Test
	public void commentEqualsTest() {
		Notificacion notificacion1 = new Notificacion();
		notificacion1.setComentario("test");
		
		Notificacion notificacion2 = new Notificacion();
		notificacion2.setComentario("test");
		
		assertEquals(notificacion1.getComentario(), notificacion2.getComentario());
	}
	
	@Test
	public void commentDifferentTest() {
		Notificacion notificacion1 = new Notificacion();
		notificacion1.setComentario("test1");
		
		Notificacion notificacion2 = new Notificacion();
		notificacion2.setComentario("test2");
		
		assertNotEquals(notificacion1.getComentario(), notificacion2.getComentario());
	}

}
