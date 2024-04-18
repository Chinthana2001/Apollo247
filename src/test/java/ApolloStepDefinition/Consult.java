package ApolloStepDefinition;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ApolloDriverSetup.BaseSteps;
import ApolloPageFactory.ConsultPageFac;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Consult {

	static WebDriver driver;
	ConsultPageFac pf;

	@Given("User is on Apollo homepage")
	public void user_is_on_apollo_homepage() throws InterruptedException {
		driver = BaseSteps.chromedriver();
//		driver = BaseSteps.edgedriver();
		pf = new ConsultPageFac(driver);
	}

	
//	===============================@INVALID=====================================
	
	@When("user is on consult page1")
	public void user_is_on_consult_page1() throws InterruptedException {
		pf.OnlineConsult();
	}

	@Then("user clicks on call option")
	public void user_clicks_on_call_option() {
		String actual="";
	    String excepted=pf.MesgDis();
	    Assert.assertEquals(actual, excepted);
	}
	
	
//	==============================SEARCH=====================================
	
	@When("user is on search by specialty page")
	public void user_is_on_search_by_specialty_page() {
	    pf.ClickOnSpec();
	}

	@And("clicks on Clinical nutrition and dietetics")
	public void clicks_on_clinical_nutrition_and_dietetics() throws InterruptedException {
	    pf.ClickOnSpecific();
	}

	@And("click on the doctor")
	public void click_on_the_doctor() throws InterruptedException, AWTException {
	    pf.button();
	}

	@Then("user should able to see specialty doctor")
	public void user_should_able_to_see_specialty_doctor() {
		String expected = pf.bookings();
	    Assert.assertTrue(expected.contains("clinical nutrition and dietetics"));
	}

	
//	==============================PROHEALTH=====================================
	
	@When("user is on proHealth page")
	public void user_is_on_pro_health_page() throws InterruptedException {
//	    pf.background();
		pf.ClickOnPro();
	}

	@And("user should click on lets go option")
	public void user_should_click_on_lets_go_option() {
	    pf.scroll();
	    pf.ClickOnLet();
	}

	@And("user clicks on health packages")
	public void user_clicks_on_health_packages() throws InterruptedException {
	    pf.scroll2();
		pf.ClickOnBook();
	}
	
	@When("^user enters (.*)")
	public void user_enters(String name) throws InterruptedException 
	{
	    pf.EnterName(name);
	}

	@When("^Enter (.*)")
	public void enter(String number) throws InterruptedException 
	{
	   pf.EnterPhone(number);
	}

	@And("selects city from dropdown")
	public void selects_city_from_dropdown() throws InterruptedException {
	    pf.SelectCity();
	}

	@Then("user should be able to get otp")
	public void user_should_be_able_to_get_otp() throws InterruptedException {
		String exp="https://www.askapollo.com/apollo-prohealth?utm_source=askapollo_below_banner&utm_medium=owned_media&utm_campaign=pro_health_below_banner";
		Assert.assertEquals(exp,driver.getCurrentUrl() );
	}


//	=============================APPOINTMENTS==================================

	@When("user is on consult page")
	public void user_is_on_consult_page() throws InterruptedException {
	    pf.background();
	}

	@When("clicks on active appointments")
	public void clicks_on_active_appointments() throws InterruptedException {
	    pf.scroll3();
		pf.ClickOnActive();
	}

	@Then("list of appointments is shown")
	public void list_of_appointments_is_shown() {
		String expected = pf.book1();
	    Assert.assertTrue(expected.contains("Mrs.padmaja Mandali"));
	}
	
	
//	=============================SHARE=========================================
	
	@When("user is on All doctors list")
	public void user_is_on_all_doctors_list() {
	    pf.AllDoctors();
	}

	@When("clicks on a doctor name")
	public void clicks_on_a_doctor_name() {
	    pf.ClickDoctor();
	}

	@When("clicks the share icon")
	public void clicks_the_share_icon() throws InterruptedException {
//	    pf.ClickShare();
	}

	@Then("it should get a message")
	public void it_should_get_a_message() throws InterruptedException {
		String expected = pf.ClickShare();
	    Assert.assertTrue(expected.contains("Obstetrics & Gynaecology"));
	}
		
	
//	============================SCREENSHOTS=====================================
	
	@AfterStep
	public static void takeScreendown(Scenario scenerio)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		final byte[] src=ts.getScreenshotAs(OutputType.BYTES);
		scenerio.attach(src, "image/png", scenerio.getName());
	}
	
}
