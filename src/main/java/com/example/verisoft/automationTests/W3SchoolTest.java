package com.example.verisoft.automationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class W3SchoolTest extends BasicTest {
    public static String BASE_URL = "https://www.w3schools.com/html/html_tables.asp";

    public W3SchoolTest() {
        driver.get(BASE_URL);
    }

    public boolean checkHtmlTables() {
        boolean isTableValid = true;
        // TODO: go over all rows in xml and check all
        WebElement table = driver.findElement(By.xpath("//table//tbody//tr"));
        int searchColumn = Integer.parseInt(xmlDataManager.getDataFromXml("column_to_search"));
        String searchText = xmlDataManager.getDataFromXml("text");
        int returnColumnText = Integer.parseInt(xmlDataManager.getDataFromXml("column_to_return"));
        String expectedText = xmlDataManager.getDataFromXml("expected_text");
        try {
            isTableValid = verifyTableCellText(table, searchColumn, searchText, returnColumnText, expectedText);
            // TODO: return in case of false/ create list of validate for each one.
        } catch (Exception e) { // TODO: catch just the custom exception
            // TODO: log.error
            System.out.println("The table is not valid: " + e.getMessage());
        }
        return isTableValid;
    }

}
