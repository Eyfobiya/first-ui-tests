package qa.projects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.open;
import static qa.projects.modals.CartModal.*;
import static qa.projects.pages.BasePage.*;
import static qa.projects.pages.CategoriesPage.*;


public class KtcTasks {

    @BeforeMethod
    public void BeforeMethod(){
        open("https://ktc.ua/");
    }

    /**
     * task1
     * Check, that cart is empty.
     * Type to search ‘iphone’.
     * Press Enter.
     * Add first product to cart.
     * Check that one product is in the cart.
     * Check that one product is displaying in cart.
     * Remove product from cart.
     * Check, that product is removed.
     */

    @Test
    public void CheckCartTask1(){
        cartButton.click();
        checkEmptyCartModal.shouldHave(Condition.text("Ваш кошик порожній"));
        closeCartModal.click();
        searchInput.setValue("iphone").pressEnter();
        buyFirstProduct.click();
        checkOpenCartModal.shouldBe(Condition.appear);
        checkProductsInCartModal.shouldHave(CollectionCondition.size(1));
        removeProductFromCartModal.click();
        checkEmptyCartModal.shouldHave(Condition.text("Ваш кошик порожній"));
    }

    /**
     * task2
     * Type ‘Apple’ to the search field.
     * Click on the button ‘Search’.
     * Check that number of categories equals to 49.
     * Open any category.
     * Check, that title contains ‘Apple’ word.
     */

    @Test
    public void CheckCategoriesTask2(){
        searchInput.setValue("Apple");
        searchButton.click();
        listOfSearchProducts.shouldHave(CollectionCondition.size(49));
        selectFirstProduct.click();
        checkTitleContainsWord.shouldHave(Condition.text("Apple"));
    }

    /**
     * task3
     * Type ‘iphone 13’ to the search field.
     * Press Enter.
     * Click on the filter AMAZINGthing.
     * Check, that number of result on the page reduced.
     */

    @Test
    public void CheckFilterResultsTask3(){
        searchInput.setValue("iphone 13").pressEnter();
        int firstCount = listOfSearchProducts.size();
        sellerAmazingThingFilterButton.click();
        listOfSearchProducts.shouldHave(CollectionCondition.sizeLessThan(firstCount));
    }
    /**
     * task4
     * Type ‘iphone’ to the search field.
     * Press Enter.
     * Choose sorting ‘from higher prices to lower’.
     * Check that the first product price is bigger, then any other random one.
     */

    @Test
    public void checkRandomSelectV1(){
        searchInput.setValue("iphone").pressEnter();
        sortListDisplayButton.click();
        sortExpensiveButton.click();
        sortListDisplayButton.shouldHave(Condition.text("Найдорожчі"));
        Wait().withTimeout(Duration.ofSeconds(3)).pollingEvery(Duration.ofMillis(500)).until(driver -> {
            List<String> collection = getProductPrice.texts();
            int productPrice1 = Integer.parseInt(collection.get(0).replaceAll("[^0-9]", ""));
            int randomProductIndex;
            do {
                randomProductIndex = new Random().nextInt(collection.size());
            } while (randomProductIndex == productPrice1);
            int productPriceRandom = Integer.parseInt(collection.get(randomProductIndex).replaceAll("[^0-9]", ""));
            System.out.println("ProductPrice1 = " + productPrice1 + "; productPriceRandom = " + productPriceRandom + ";");
            return productPrice1 > productPriceRandom;
        });
    }
    @Test
    public void checkRandomSelectV2(){
        searchInput.setValue("iphone").pressEnter();
        sortListDisplayButton.click();
        sortExpensiveButton.click();
        sortListDisplayButton.shouldHave(Condition.text("Найдорожчі"));
        Wait().withTimeout(Duration.ofSeconds(3)).pollingEvery(Duration.ofMillis(500)).until(driver -> {
            List<String> collection = getProductPrice.texts();
            int productPrice1 = Integer.parseInt(collection.get(0).replaceAll("[^0-9]", ""));
            int randomProductIndex = new Random().nextInt(collection.size() - 1) + 1;
            int productPriceRandom = Integer.parseInt(collection.get(randomProductIndex).replaceAll("[^0-9]", ""));
            System.out.println("ProductPrice1 = " + productPrice1 + "; productPriceRandom = " + productPriceRandom + ";");
            return productPrice1 > productPriceRandom;
        });
    }
    /**
     * task5
     * Type ‘iphone’ to the search field.
     * Press Enter.
     * Choose sorting ‘from higher prices to lower’.
     * Check that the first product price is bigger, that any next product.
     */

    @Test
    public void checkSortingTask5(){
        searchInput.setValue("iphone").pressEnter();
        sortListDisplayButton.click();
        sortExpensiveButton.click();
        sortListDisplayButton.shouldHave(Condition.text("Найдорожчі"));
        Wait().withTimeout(Duration.ofSeconds(3)).pollingEvery(Duration.ofMillis(500)).until(driver -> {
            List<String> collection = getProductPrice.texts();
            int ProductPrice1 = Integer.parseInt(collection.get(0).replaceAll("[^0-9]", ""));
            int ProductPrice2 = Integer.parseInt(collection.get(4).replaceAll("[^0-9]", ""));
            System.out.println("ProductPrice1 = " + ProductPrice1 + "; productPrice2 = " + ProductPrice2 + ";");
            return ProductPrice1 > ProductPrice2;
        });
    }
}
