package com.example.verisoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchTextUtils {

    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) {
       String text = null;
        WebElement row = table.findElement(By.xpath("//table//tbody//tr[./td["+searchColumn+"][contains(text(),'"+searchText+"')]]"));
        if(row != null){
            text = row.findElement(By.xpath("./td["+returnColumnText+"]")).getText();
            // TODO: insert Logger and use log.info()
            System.out.println("found text: " + text);
        }
        return text;
    }
}
