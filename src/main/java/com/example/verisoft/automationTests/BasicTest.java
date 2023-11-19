package com.example.verisoft.automationTests;

import com.example.verisoft.SearchTextUtils;
import com.example.verisoft.XmlDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicTest {

    public WebDriver driver;
    XmlDataManager xmlDataManager;
    SearchTextUtils searchTextUtils;


    public BasicTest(){
        System.setProperty("webdriver.chrome.driver", "chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        xmlDataManager = new XmlDataManager();
        searchTextUtils = new SearchTextUtils();
    }

    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) throws Exception {
        String currentText = searchTextUtils.getTableCellTextByXpath(table, searchColumn, searchText, returnColumnText);
        if(currentText == null){
            // TODO : implementCustomException
            throw new Exception("the element: "+ currentText + " is not found in searchColum");
        }
        return  currentText.equals(expectedText);
    }


    public void closeDriver(){
        driver.quit();
    }
}
