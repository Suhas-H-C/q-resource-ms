package org.rest.resource.ms.IT;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.*;
import static org.rest.resource.ms.util.ArtistTestUtil.artistJohn;

@QuarkusIntegrationTest
@TestTransaction
class ArtistResourceIT
        // extends ArtistResourceTest <- Commenting as it pulls all tests executing against prod configuration
        // Execute the same tests but in packaged mode.
{

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
                .body("name", equalTo("A"))
                .body("age", equalTo(25))
                .body("bio", equalTo("A bio"));
    }

    @Test
    void should_return_all_artist() {
        given()
                .when()
                .get("/artists")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("[0].id", equalTo(1))
                .body("[0].name", equalTo("A"))
                .body("[0].age", equalTo(25))
                .body("[0].bio", equalTo("A bio"));
    }

    @Test
    void should_throw_exception_when_artistById_is_not_found() {
        given()
                .when()
                .delete("/artists/238746")
                .then()
                .statusCode(404)
                .body(not(empty()));
    }
}
