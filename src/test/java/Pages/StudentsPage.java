package Pages;

import Base.BasePage;
import Common.CommonPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentsPage extends BasePage {

    CommonPage cp=new CommonPage();

    @FindBy(xpath="//a[text()='Students']")
    WebElement studentsMenu;


    @FindBy(xpath = "/html/body/div/p/a")
    WebElement lnkCreateNew;

    //Create Heading
    @FindBy(xpath = "//h2[text()='Create']")
    WebElement headingCreate;

    //Students Info
    @FindBy(id="LastName")
    WebElement lastName;

    @FindBy(id="FirstMidName")
    WebElement firstName;

    @FindBy(id="EnrollmentDate")
    WebElement enrollmentDate;

    @FindBy(xpath ="//input[@class='btn btn-default']")
    WebElement createButton;


    public StudentsPage() {
        PageFactory.initElements(wd,this);
    }

    public void navigateStudentsmenu(){
        studentsMenu.click();
    }

    public void clickCreateNew(){
        lnkCreateNew.click();
    }

    public void verifyHeadingCreate(){
        cp.isElementDisplayed(headingCreate);
    }

    public void enterFirstName(){
        cp.enterData(firstName,prop.getProperty("FIRST_NAME"));
    }

    public void enterLastName(){
        cp.enterData(lastName,prop.getProperty("LAST_NAME"));
    }

    public void enterEnrollmentDate(){
        String pattern = "MM/DD/YYYY";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        cp.enterData(enrollmentDate, date);
    }

    public void clickCreateButton(){
        createButton.click();
    }

    public String getHomePageTitle(){
        return wd.getTitle();
    }


}



