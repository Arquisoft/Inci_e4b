package e4b.InciManager_e4b;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import asw.database.entities.Incidence;
import asw.producers.KafkaProducer;
import cucumber.api.java.Before;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InciManagerE4bApplicationTests.class)
public class InciManagerE4bApplicationTests {
	private WebDriver driver= new HtmlUnitDriver();;
	
	private String url;
	private StringBuffer verificationErrors = new StringBuffer();


	
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void loginTestInterface() {
	
		url = "http://localhost:8080/login";
		driver.navigate().to(url);
		
		new WebDriverWait(driver, 30)
		.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));	
		
		driver.findElement(By.id("userid")).sendKeys("paco@hotmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("login")).click();
		new WebDriverWait(driver, 30)
		.until(ExpectedConditions.visibilityOfElementLocated(By.name("incidenceName")));	
		assertNotNull(driver.findElement(By.name("incidenceName")));
	
		
	}
	@Test
	public void incidenceTestInterface() {
		url = "http://localhost:8080/login";
		driver.navigate().to(url);
		
		new WebDriverWait(driver, 30)
		.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));	
		
		driver.findElement(By.id("userid")).sendKeys("paco@hotmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("login")).click();
			
		new WebDriverWait(driver, 30)
		.until(ExpectedConditions.visibilityOfElementLocated(By.name("incidenceName")));
		
		driver.findElement(By.name("incidenceName")).sendKeys("Test");
		driver.findElement(By.name("descripcion")).sendKeys("Desc Test");
		driver.findElement(By.name("latitude")).sendKeys("11111");
		driver.findElement(By.name("longitude")).sendKeys("22222");
		driver.findElement(By.id("create")).click();
		
		//Mensaje de creacion aparece
		assertNotNull(driver.findElement(By.name("incidenceCreatedText")));
	}
	
	@Test
	public void IncidenceJsonTest() {
		
		Incidence o = new Incidence();
		KafkaProducer kp = new KafkaProducer();
		String JSON="";
		try {
			JSON = kp.IncidenceToJson(o);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			fail();
		}
		
		try {
			assertEquals(kp.JsonToIncidence(JSON), o);
		} catch (JsonParseException e) {
			e.printStackTrace();
			fail();
		} catch (JsonMappingException e) {
			e.printStackTrace();
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void IncidenceIdJsonTest() {
		
		Incidence o = new Incidence();
		KafkaProducer kp = new KafkaProducer();
		String JSON="";
		try {
			JSON = kp.IncidenceIdToJson(o);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			fail();
		}
		
		try {
			assertEquals(kp.JsonToIncidence(JSON), o.getId());
		} catch (JsonParseException e) {
			e.printStackTrace();
			fail();
		} catch (JsonMappingException e) {
			e.printStackTrace();
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

}
