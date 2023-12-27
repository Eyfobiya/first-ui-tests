package qa.projects.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoriesPage {
    public static SelenideElement sortListDisplayButton = $(".catalog__goods .sorting .sorting__selected");
    public static SelenideElement sortExpensiveButton = $(".tooltip .sorting__choiselist .sorting__item:nth-child(3)");
    public static SelenideElement sellerAmazingThingFilterButton = $(".filter-content .filter__item-checkbox:nth-child(2)");
    public static ElementsCollection listOfSearchProducts = $$(".js-looplist .loop");
    public static ElementsCollection getProductPrice = $$(".js-looplist .loop .loop__price div");
    public static SelenideElement buyFirstProduct = $(".js-looplist .loop__container:nth-child(1) .loop__buy");
    public static SelenideElement selectFirstProduct = $(".js-looplist .loop:nth-child(1)");
    public static SelenideElement checkTitleContainsWord = $(".breadcrumbs .breadcrumbs__li:nth-child(4)");
}
