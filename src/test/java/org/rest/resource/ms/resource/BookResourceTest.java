package org.rest.resource.ms.resource;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.rest.resource.ms.config.WireMockExtensions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
@QuarkusTestResource(WireMockExtensions.class)
public class BookResourceTest {


    @Test
    void should_create_a_book_when_data_is_passed() {
        var title = "The Lord of the Rings";
        var author = "J.R.R. Tolkien";
        var genre = "Fantasy";
        var yearOfPublication = 1954;
        given()
                .formParam("title", title)
                .formParam("author", author)
                .formParam("yearOfPublication", yearOfPublication)
                .formParam("genre", genre)
                .when()
                .post("/v1/save")
                .then()
                .statusCode(201)
                .body("author", is(author))
                .body("year_of_publication", is(yearOfPublication))
                .body("genre", is(genre))
                .body("creation_date", notNullValue())
                .body(not(hasKey("yearOfPublication")))
                .body(not(hasKey("creationDate")));
    }
}