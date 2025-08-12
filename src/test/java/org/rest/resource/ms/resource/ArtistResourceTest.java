package org.rest.resource.ms.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.*;
import static org.rest.resource.ms.util.ArtistTestUtil.artistJohn;

@QuarkusTest
public class ArtistResourceTest {

    @Test
    void should_save_artist() {
        given()
                .contentType(APPLICATION_JSON)
                .body(artistJohn())
                .when()
                .post("/artists")
                .then()
                .statusCode(201)
                .body(equalTo("true"));
    }

    @Test
    void should_return_artist_when_Id_is_passed() {
        given()
                .when()
                .get("/artists/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("John"))
                .body("age", equalTo(26))
                .body("bio", equalTo("John is a good boy"));
    }

    @Test
    void should_return_all_artist() {
        given()
                .when()
                .get("/artists")
                .then()
                .statusCode(200)
                .body("[0].id", equalTo(1))
                .body("[0].name", equalTo("John"))
                .body("[0].age", equalTo(26))
                .body("[0].bio", equalTo("John is a good boy"));
    }

    @Test
    void should_throw_exception_when_artistById_is_not_found() {
        given()
                .when()
                .delete("/artists/5001")
                .then()
                .statusCode(404)
                .body(not(empty()));
    }
}