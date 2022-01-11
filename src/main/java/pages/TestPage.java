package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestPage {
    private final SelenideElement countItemsSpan = $("#topcartlink span.cart-qty");

    public Cookie getProduct() {
        return getWebDriver().manage().getCookieNamed("NopCommerce.RecentlyViewedProducts");
    }

    public Cookie getCustomer() {
        return getWebDriver().manage().getCookieNamed("Nop.customer");
    }


    public TestPage open() {
        Selenide.open("/books");
        return this;
    }

    public TestPage countItemsShouldBe(String count) {
        countItemsSpan
                .shouldBe(visible)
                .shouldHave(exactText(String.format("(%s)", count)));
        return this;
    }

    public TestPage refreshPage() {
        refresh();
        return this;
    }
}
