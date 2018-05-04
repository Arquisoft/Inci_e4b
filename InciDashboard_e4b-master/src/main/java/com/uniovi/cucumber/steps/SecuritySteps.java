package com.uniovi.cucumber.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SecuritySteps {
	
	static WebDriver driver;
	static String URL = "http://localhost:8090";
	
	public static WebDriver getDriver() {	
		driver = new HtmlUnitDriver();
		return driver;
	}

	@Given("^A user with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	
	public void a_user_with_username_and_password(String nombre, String password) throws Throwable {
		driver = getDriver();
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
