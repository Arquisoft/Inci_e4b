package com.uniovi.cucumber.steps;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class SecuritySteps {
	static String PathFirefox = "C:\\Users\\UO251461\\Downloads\\sts-bundle\\Firefox46.win\\FirefoxPortable.exe";
	
	static WebDriver driver;
	static String URL = "http://localhost:8090";
	
	public static WebDriver getDriver(String PathFirefox) {
		// Firefox (Versión 46.0) sin geckodriver para Selenium 2.x.
//		System.setProperty("webdriver.firefox.bin", PathFirefox);
//		WebDriver driver = new FirefoxDriver();		
		driver = new HtmlUnitDriver();
		return driver;
	}

	@Given("^A user with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	
	public void a_user_with_username_and_password(String nombre, String password) throws Throwable {
		driver = getDriver(PathFirefox);
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		WebElement element = driver.findElement(By.name("username"));
		element.click();
		element.sendKeys(nombre);
		
		element = driver.findElement(By.name("password"));
		element.click();
		element.sendKeys(password);
		
		By boton = By.className("btn");
		driver.findElement(boton).click();
		System.out.println("Hace clik en boton Entrar");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println("Usuario " + nombre +" con pass " + password);
	}

	@When("^the user go to \"([^\"]*)\"$")
	public void the_user_go_to(String url) throws Throwable {
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	@Then("^the user see the following text \"([^\"]*)\"$")
	public void the_user_should_see_the_following_text(String textoEsperado) throws Throwable {
		String textoActual = driver.findElement(By.tagName("h2")).getText();
		driver.quit();
		assertEquals(textoActual, textoEsperado);
	}
}
