package org.rest.resource.ms.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.MediaType;
import org.rest.resource.ms.entity.Artist;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class ArtistResourceTest {

    @Test
    void should_create_artist_and_return_when_Id_is_passed() {
        Artist john = new Artist("John", "John's bio", 25);
        given()
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .body(john)
                .when()
                .post("/artists")
                .then()
                .statusCode(201)
                .body(equalTo("true"));
    }

    @Test
    void should_throw_exception_when_artistById_is_not_found() {
        given()
                .when()
                .delete("/artists/501")
                .then()
                .log()
                .all()
                .statusCode(404)
                .body(Matchers.not(empty()));
    }
}