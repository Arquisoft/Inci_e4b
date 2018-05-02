package com.uniovi.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_LoginView extends PO_NavView{

	public static void fillForm(WebDriver driver, String emailp, String passwordp) {
		WebElement username = driver.findElement(By.name("username"));
		username.click();
		username.clear();
		username.sendKeys(emailp);

		WebElement password = driver.findElement(By.name("password"));
		password.click();
		password.clear();
		password.sendKeys(passwordp);

		// Pulsar el boton de Alta.
		By boton = By.className("btn");
		driver.findElement(boton).click();
		
	}
	
	public static void fillAdminForm(WebDriver driver, String emailp, String passwordp) {
		WebElement username = driver.findElement(By.name("email"));
		username.click();
		username.clear();
		username.sendKeys(emailp);

		WebElement password = driver.findElement(By.name("password"));
		password.click();
		password.clear();
		password.sendKeys(passwordp);

		// Pulsar el boton de Alta.
		By boton = By.className("btn");
		driver.findElement(boton).click();
		
	}
	
	public static void fillSearchForm(WebDriver driver, String searchText) {
		WebElement barraBuscar = driver.findElement(By.name("searchText"));
		barraBuscar.click();
		barraBuscar.clear();
		barraBuscar.sendKeys(searchText);

		// Pulsar el boton de Alta.
		By boton = By.className("btn");
		driver.findElement(boton).click();
		
	}

}
