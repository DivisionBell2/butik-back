package ru.butik;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import ru.butik.logic.Specification;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class TC001_GET_Cart implements Specification {

    @Test
    void getCart() {
        RestAssured
                .given()
                .spec(getRequestSpecification("v2/cart"))
                .get()
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File("src/main/resources/jsonSchemaResponse/cart.json")))
        ;
    }
}
