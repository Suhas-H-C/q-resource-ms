package org.rest.resource.ms.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class EmployeeResourceTest {

    @Test
    void should_return_all_employees() {
        given()
                .when()
                .get("/v1/emp")
                .then()
                .statusCode(200)
                .body("size()", is(2));
    }

    @Test
    void should_return_employee_when_Id_is_passed() {
        given()
                .when()
                .get("/v1/emp/1")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Employee1"));
    }

    @Test
    void should_return_badRequest_when_context_id_wrong() {
        given()
                .when()
                .get("/v1/employee/1")
                .then()
                .statusCode(404);
    }
}