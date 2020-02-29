package ru.butik.logic;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

public interface Specification {
    default RequestSpecification getRequestSpecification(String path) {
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .setContentType(ContentType.JSON)
                .setBaseUri("https://www.butik.ru/api/")
                .setBasePath(path)
                .build()
                ;
    }
}
