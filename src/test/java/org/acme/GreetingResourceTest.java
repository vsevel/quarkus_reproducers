package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

    protected String expectedFoo() {
        return "bar";
    }

    @Test
    void testFooEndpoint() {
        given()
                .when().get("/hello/foo")
                .then()
                .statusCode(200)
                .body(is("foo="+expectedFoo()));
    }

}