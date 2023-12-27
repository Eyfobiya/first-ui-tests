package qa.projects.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    public static SelenideElement cartButton = $(".header__right .header__cart");
    public static SelenideElement searchInput = $("[name='q']");
    public static SelenideElement searchButton = $(".header__center .hiddenMobile");
}
