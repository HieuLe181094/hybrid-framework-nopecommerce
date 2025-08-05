package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.pim.employee.AddNewEmployeePO;
import pageObjects.orangeHRM.pim.employee.EmployeeListPO;
import pageUIs.orangeHRM.DashboardPagePIM_UI;

public class DashboardPageObject extends BasePage {
  private final WebDriver driver;

  public DashboardPageObject(WebDriver driver) {
      this.driver = driver;
    }


  public EmployeeListPO clickToPIMPage() {
    waitForElementVisible(driver, DashboardPagePIM_UI.PIM_LINK);
    clickToElement(driver, DashboardPagePIM_UI.PIM_LINK);
    waitAllLoadingIconInvisible(driver);
    return PageGenerator.getEmployeeListPage(driver);
  }
}
