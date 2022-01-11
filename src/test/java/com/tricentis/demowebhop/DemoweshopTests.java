package com.tricentis.demowebhop;

import api.Requests;
import org.junit.jupiter.api.Test;
import pages.TestPage;

public class DemoweshopTests extends BaseTest{

    private TestPage page = new TestPage();
    private Requests requests = new Requests();

    @Test
    void addItemToCartTest() {
        page.open()
            .countItemsShouldBe("0");
        requests.addItem(page);
        page.refreshPage()
            .countItemsShouldBe("1");
    }
}
