package BDD.StepsDef;

import Base.BasePage;
import Pages.StudentsPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class StudentDefs extends BasePage {

    public StudentsPage studentsPage;

    @Before
    public void setUp() throws InterruptedException {
        initialization();
        studentsPage=new StudentsPage();
    }

    @Given("^User is in student menu$")
    public void userIsInStudentMenu() throws InterruptedException {
        studentsPage.navigateStudentsmenu();
        Thread.sleep(5000);
    }

    @When("^User clicks on new student link$")
    public void userClicksOnNewStudentLink() throws InterruptedException {
        studentsPage.clickCreateNew();
        Thread.sleep(5000);
    }

    @Then("^User verifies create heading$")
    public void userVerifiesCreateHeading() {
        studentsPage.verifyHeadingCreate();
    }

    @When("^User enters last name$")
    public void userEntersLastName() throws InterruptedException {
        studentsPage.enterLastName();
        Thread.sleep(3000);
    }

    @And("^User enters first name$")
    public void userEntersFirstName() throws InterruptedException {
        // Enter forms Value
        studentsPage.enterFirstName();
        Thread.sleep(3000);
    }


    @And("^User enters enrollment date$")
    public void userEntersEnrollmentDate() throws InterruptedException {
        studentsPage.enterEnrollmentDate();
        Thread.sleep(3000);
    }

    @And("^User click on create button$")
    public void userClickOnCreateButton() {
        studentsPage.clickCreateButton();
    }

    @Then("^Verify User added is listed on the student list$")
    public void verifyUserAddedIsListedOnTheStudentList() throws InterruptedException {
        //
        String searchStudent="Sandesh";
        byte count=0;
        List<String> students=new ArrayList<>();
        students=studentsPage.getAllStudentsNameList();
        for(String eachStudent:students){
            System.out.println(eachStudent);
            if(eachStudent.equals(searchStudent))
                count++;
        }
        if(count!=0)
            Assert.assertTrue(true);
        else
            Assert.assertFalse(false);
    }

}
