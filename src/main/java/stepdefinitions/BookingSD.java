package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.SearchResult;

import java.time.Duration;
import java.util.ArrayList;

import static stepdefinitions.SharedSD.getDriver;

public class BookingSD {

    SearchResult searchResult = new SearchResult();

    @Given("I am on default locations search result screen")
    public void i_am_on_default_locations_search_result_screen() {

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         try {

             searchResult.closeInitialPopUp();
         }
         catch (Exception e)
         {

         }

    }
    @Then("I verify {string} is within the search result")
    public void i_verify_is_within_the_search_result(String hotelName) {
        ArrayList<String> hotelList = searchResult.getHotelList();

       boolean result =  hotelList.contains(hotelName);

       /* for (String hotel:hotelList)
            System.out.println(hotel);*/


        Assert.assertTrue("Given hotel is not present",result);


    }

    @Then("I verify system displays all hotels within {string} amount")
    public void iVerifySystemDisplaysAllHotelsWithinAmount(String maxAmountStr) {

       int expectedMaxAmount =  Integer.parseInt(maxAmountStr);

        ArrayList<Integer> priceList = searchResult.getPriceList();
        System.out.println(priceList);

        ArrayList<Integer> greaterPriceList = new ArrayList<>();
        boolean result = true;
        for (int price:priceList)
        {
            if(price>expectedMaxAmount)
            {
                greaterPriceList.add(price);
                result = false;
            }
        }

        Assert.assertTrue("some hotels pricing is greater than:"
                +expectedMaxAmount+
                "\nBelow is the list of greater prices\n"+greaterPriceList,result);
    }
}
