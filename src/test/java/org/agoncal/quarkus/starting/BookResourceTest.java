package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {
    @Test
    void shouldGetAllBooks() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
        when()
            .get("/api/books").
        then()
            .statusCode(200)
            .body("size()", is(4));
    }

    @Test
    void shouldCountAllBooks() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).
        when()
            .get("/api/books/count").
        then()
            .statusCode(200)
            .body(is("4"));
    }

    @Test
    void shouldGetABook() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
            .pathParam("id", 1).
        when()
            .get("/api/books/{id}").
        then()
            .statusCode(200)
            .body("title", is("Book 1"))
            .body("author", is("Author 1"))
            .body("yearOfPublication", is(2020))
            .body("genre", is("IT"));

    }
}