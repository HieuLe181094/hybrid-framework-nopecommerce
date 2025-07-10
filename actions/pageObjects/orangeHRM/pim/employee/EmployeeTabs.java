package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.PageGenerator;
import pageUIs.orangeHRM.pim.employee.EmployeeTabsPIM_UI;

public class EmployeeTabs extends BasePage {
    private WebDriver driver;

    public EmployeeTabs(WebDriver driver){
        this.driver = driver;
    }

    public PersonalDetailsPO openPersonalDetailsPage(){
        waitForElementClickable(driver, EmployeeTabsPIM_UI.PERSONAL_DETAIL_PAGE);
        clickToElement(driver, EmployeeTabsPIM_UI.PERSONAL_DETAIL_PAGE);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }


    public EmergencyContactsPO openEmergencyContactsPage(){
        waitForElementClickable(driver, EmployeeTabsPIM_UI.EMERGENCY_CONTACTS_PAGE);
        clickToElement(driver, EmployeeTabsPIM_UI.EMERGENCY_CONTACTS_PAGE);;
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmergencyContactsPage(driver);
    }

    public ContactDetailsPO openContactDetailPage() {
        waitForElementClickable(driver, EmployeeTabsPIM_UI.CONTACT_DETAIL_PAGE);
        clickToElement(driver, EmployeeTabsPIM_UI.CONTACT_DETAIL_PAGE);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getContactDetailsPage(driver);
    }
}