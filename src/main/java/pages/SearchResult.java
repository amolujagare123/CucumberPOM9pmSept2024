package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static stepdefinitions.SharedSD.getDriver;

public class SearchResult extends Base {

    By hotelListElement = By.xpath("//div[@data-testid='title']") ;

    public ArrayList<String> getHotelList()
    {
        return getElementTextList(hotelListElement);
    }

    By popUpCloseBtn = By.xpath("//button[contains(@aria-label,'Dismiss')]");

    public void closeInitialPopUp()
    {
        clickOn(popUpCloseBtn);
    }

    By rawPriceList = By.xpath("//span[@data-testid='price-and-discounted-price']");



    public ArrayList<Integer> getPriceList()
    {
        ArrayList<String> rawList = getElementTextList(rawPriceList);
        ArrayList<Integer> priceList = new ArrayList<>();

        for(String rawPriceStr:rawList) // ₹ 5,700
        {
            String rawPriceStr2 = rawPriceStr.substring(2); // 5,700
            String priceStr = rawPriceStr2.replace(",","");// 5700
            int price = Integer.parseInt(priceStr);
            priceList.add(price);
        }

        return priceList;
    }

    public void clickStarRating(String star)
    {
        By rating = By.xpath("//div[@data-filters-item='class:class="+star+"']");
        clickOn(rating);
    }

    By ratingStar = By.xpath("//div[contains(@aria-label,'out of 5')]");

    public ArrayList<Integer> getStarList()
    {
        List<WebElement> wbList = getDriver().findElements(ratingStar); // 25

        System.out.println(wbList.size()); // 25

        ArrayList<Integer> starList = new ArrayList<>();

        for (WebElement wb:wbList)
        {
            String value = wb.getAttribute("aria-label"); // 5 out of 5
            String starStr = value.substring(0, 1); // 5 - string
            int star = Integer.parseInt(starStr); // 5 - int
            starList.add(star);
        }

        return starList;
    }

}
