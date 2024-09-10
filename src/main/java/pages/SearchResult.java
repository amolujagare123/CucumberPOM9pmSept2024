package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

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

}
