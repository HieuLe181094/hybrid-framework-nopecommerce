package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.nopCommerce.AdminCustomerPageUI;
import utilities.SQLServerConfig;

import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminCustomerPageObject extends BasePage {
    WebDriver driver;

    public AdminCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public int getAllCustomerNumberUI() {
        waitForElementVisible(driver, AdminCustomerPageUI.CUSTOMER_GRID_INFO);
        String allItems = getElementText(driver, AdminCustomerPageUI.CUSTOMER_GRID_INFO);
        // allItems ví dụ: "1-15 of 35 items"

        Pattern integerPattern = Pattern.compile("of\\s+(\\d+)\\s+items");
        Matcher integerMatcher = integerPattern.matcher(allItems);
        String result = null;

        if (integerMatcher.find()) {
            result = integerMatcher.group(1); // lấy "35"
        } else {
            throw new RuntimeException("Không tìm thấy tổng số items trong chuỗi: " + allItems);
        }

        return Integer.valueOf(result); // ✅ parse đúng giá trị số
    }



    public void enterToEmailTextboxSearch(String emailAddress) {
        waitForElementVisible(driver, AdminCustomerPageUI.EMAIL_TEXTBOX_SEARCH);
        sendkeyToElement(driver, AdminCustomerPageUI.EMAIL_TEXTBOX_SEARCH, emailAddress );
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, AdminCustomerPageUI.SEARCH_BUTTON);
        clickToElement(driver, AdminCustomerPageUI.SEARCH_BUTTON);
    }

    public boolean isCustomerPageDisplayed(String emailAddress) {
        waitForElementVisible(driver, AdminCustomerPageUI.CUSTOMER_PAGE_RESULT, emailAddress);
        return isElementDisplayed(driver, AdminCustomerPageUI.CUSTOMER_PAGE_RESULT, emailAddress);
    }

    public int getAllCustomerNumberInDatabase() {
        ArrayList<String> listNumber = new ArrayList<>();
        String sql = "SELECT * FROM [nopcommerce].[dbo].[Customer] WHERE Username IS NOT NULL;";
        Connection conn = null;
        try {
            conn = SQLServerConfig.getSQLServerConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                listNumber.add(rs.getString("Username"));
            }
            System.out.println(("Sum = " + listNumber.size()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return listNumber.size();
    }

    public boolean isEmailAddressInDatabase(String emailAddress) {
        ArrayList<String> listEmail = new ArrayList<>();
        String sql = "SELECT Email FROM [nopcommerce].[dbo].[Customer] WHERE Email = ?;";
        Connection conn = null;

        try {
            conn = SQLServerConfig.getSQLServerConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, emailAddress);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                listEmail.add(rs.getString("Email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Chỉ cần biết có ít nhất 1 record khớp email
        return !listEmail.isEmpty();
//        ArrayList<String> listEmail = new ArrayList<>();
//        String sql = "SELECT Email FROM [nopcommerce].[dbo].[Customer] WHERE Email = ?;";
//        Connection conn = null;
//
//        try {
//            conn = SQLServerConfig.getSQLServerConnection();
//            PreparedStatement pstm = conn.prepareStatement(sql);
//            pstm.setString(1, emailAddress);
//            ResultSet rs = pstm.executeQuery();
//
//            while (rs.next()) {
//                listEmail.add(rs.getString("Email"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        // Chỉ cần biết có ít nhất 1 record khớp email
//        return !listEmail.isEmpty();
    }


}
