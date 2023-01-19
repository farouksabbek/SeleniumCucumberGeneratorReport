package stepDefinition;

import com.coinHouse.base.Base;
import com.coinHouse.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class LoginSteps extends Base {

    LoginPage loginPage = new LoginPage();

    @Given("I go to the app")
    public void openSite() {
        System.out.println("-----------------Test Start-----------------");
    }
    @When("I click on search")
    public void clicKSearch() {
        driver.findElement(By.xpath("(//*[@value='Recherche Google'  and @name='btnK'])[2]")).click();
    }

    @When("I add text  {string} and {string}")
    public void iAddTextAnd(String arg0, String arg1) throws InterruptedException {
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(arg0);
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(arg1);
    }

    @When("I add {string} and {string}")
    public void iAddAnd(String email, String password) {
        loginPage.connectToTheApp(email,password);
    }

    @And("click on login")
    public void clickOnLogin() {
        loginPage.verifyAccount();
    }
    @Given("I open the site")
    public void iOpenTheSite() {
        driver.get("https://www.google.com/");
    }

    @When("I connect to the app")
    public void iConnectToTheApp() {
        loginPage.connectToTheAppWithProp();
    }
}
