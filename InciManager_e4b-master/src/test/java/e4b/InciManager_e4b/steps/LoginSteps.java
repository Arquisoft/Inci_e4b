package e4b.InciManager_e4b.steps;

import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import asw.controllers.AgentsController;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
  
  private static final Logger LOG = LoggerFactory.getLogger(AgentsController.class);

	private WebDriver driver;
	
	private String baseUrl;
	@SuppressWarnings("unused")
	private StringBuffer verificationErrors = new StringBuffer();


	@Before
	public void setUp() {
		driver = new HtmlUnitDriver();
		baseUrl = "http://localhost:8080/login";
		driver.navigate().to(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}



	@Given("^a registered agent with name \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void a_registered_agent_with_name_and_password(String username, String password) throws Throwable {
		LOG.info("Un agente registrado en el sistema con el nombre de usuario: '" + username
				+ "' y  contraseña: '" + password + "'");
	}
	@When("^the username \"([^\"]*)\" and  password \"([^\"]*)\" are correct$")
	public void the_username_and_password_are_correct(String username, String password) throws Throwable {
		LOG.info("El agente introduce los datos: '" + username
				+ "' y  contraseña: '" + password + "'");
		new WebDriverWait(driver, 30)
		.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));	
		driver.findElement(By.id("userid")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
	}




	@Then("^the agent can create an incidence in the url \"([^\"]*)\"$")
	public void the_agent_can_create_an_incidence_in_the_url(String url) throws Throwable {
		LOG.info("Entonces puedo procesar incidencias desde la página principal: '" + url + "'");
		driver.navigate().to(url);
		assertNotNull(driver.findElement(By.name("incidenceName")));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		
}
  
  
  public static class User {
    @SuppressWarnings("unused")
	private String name;
    @SuppressWarnings("unused")
	private String password;
  }
}
