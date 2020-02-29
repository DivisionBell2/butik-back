package ru.butik;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import ru.butik.logic.Specification;

import java.io.File;
import java.util.HashMap;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class TC002_POST_Login implements Specification {

    public HashMap getBodyForLogin() {
        return new HashMap() {{
            put("email", "neglavmag@gmail.com");
            put("password", "cnfylfhnysq");
        }};
    }

    @Test
    void postLogin() {
        RestAssured
                .given()
                .spec(getRequestSpecification("login"))
                .body(getBodyForLogin())
                .post()
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File("src/main/resources/jsonSchemaResponse/login.json")))
        ;
    }
}
