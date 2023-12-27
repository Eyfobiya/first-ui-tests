package qa.projects.modals;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartModal {
    public static SelenideElement checkEmptyCartModal = $(".cart__empty");
    public static SelenideElement closeCartModal = $(".cart__close");
    public static SelenideElement checkOpenCartModal = $(".cart__content .cart__items");
    public static ElementsCollection checkProductsInCartModal = $$(".cart__content .cart__items");
    public static SelenideElement removeProductFromCartModal = $(".cart__itemremove");
}
