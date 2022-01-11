package api;

import pages.TestPage;

import static com.codeborne.selenide.Selenide.refresh;
import static io.restassured.RestAssured.given;

public class Requests {
    public void addItem(TestPage page) {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("")
                .cookie(String.valueOf(page.getCustomer()))
                .cookie(String.valueOf(page.getProduct()))
                .when()
                .post("/addproducttocart/catalog/13/1/1")
                .then()
                .statusCode(200);
    }
}
