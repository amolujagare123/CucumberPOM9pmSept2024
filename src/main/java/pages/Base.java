package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static stepdefinitions.SharedSD.getDriver;

public class Base {

    public WebElement webAction(By locator)
    {
        return getDriver().findElement(locator);
    }

    public void clickOn(By locator)
    {
        webAction(locator).click();
    }

    public void setValue(By locator,String value)
    {
        webAction(locator).sendKeys(value);
    }

    public String getValue(By locator)
    {
        return webAction(locator).getText();
    }

    public ArrayList<String> getElementTextList(By locator)
    {
        List<WebElement> wbList = getDriver().findElements(locator);

        ArrayList<String> txtList = new ArrayList<>();

        for(WebElement wb:wbList)
        {
            txtList.add(wb.getText());
        }

        return txtList;
    }

}
