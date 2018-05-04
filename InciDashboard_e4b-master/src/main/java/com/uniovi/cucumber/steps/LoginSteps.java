package com.uniovi.cucumber.steps;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

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

public class LoginSteps {
	static String PathFirefox = "C:\\Users\\UO251461\\Downloads\\sts-bundle\\Firefox46.win\\FirefoxPortable.exe";
	
	static WebDriver driver;
	static String URL = "http://localhost:8090";
	
	public static WebDriver getDriver(String PathFirefox) {
//		// Firefox (Versión 46.0) sin geckodriver para Selenium 2.x.
//		System.setProperty("webdriver.firefox.bin", PathFirefox);
//		WebDriver driver = new FirefoxDriver();		
		driver = new HtmlUnitDriver();
		return driver;
	}

	@Given("^I open the browser and go to the website login$")
	public void i_open_the_browser_and_go_to_the_website_login() throws Throwable {
		driver = getDriver(PathFirefox);
		driver.navigate().to(URL);
		System.out.println("Abro el navegador y voy a login");
	}

	@When("^the user username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void the_user_username_and_password(String nombre, String password) throws Throwable {
		WebElement element = driver.findElement(By.name("username"));
		element.click();
		element.sendKeys(nombre);
		
		element = driver.findElement(By.name("password"));
		element.click();
		element.sendKeys(password);
		System.out.println("Usuario " + nombre +" con pass " + password);
	}

	@When("^the user press login button$")
	public void the_user_press_login_button() throws Throwable {
		By boton = By.className("btn");
		driver.findElement(boton).click();
		System.out.println("Hace clik en boton Entrar");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Then("^the user should see the following text \"([^\"]*)\"$")
	public void the_user_should_see_the_following_text(String textoEsperado) throws Throwable {
		String textoActual = driver.findElement(By.tagName("h2")).getText();
		driver.quit();
		assertEquals(textoActual, textoEsperado);
	}
}
