package org.rest.resource.ms.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static java.util.Objects.nonNull;

public class WireMockExtensions implements QuarkusTestResourceLifecycleManager {

    private WireMockServer wireMockServer;

    @Override
    public Map<String, String> start() {
        wireMockServer = new WireMockServer(8221);
        wireMockServer.start();

        // Stubbing numbers endpoint for ISBN
        wireMockServer.stubFor(
                get("/v1/numbers")
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBody("{\"isbn13\":\"13-1234567890123\"}")));

        // Stubbing numbers endpoint for Employees
        wireMockServer.stubFor(
                post("/")
                        .withRequestBody(matchingJsonPath("$.query",containing("employees")))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBody("""
                                        {
                                            "data": {
                                            "employees": [
                                                {"id":1,"name":"A"},
                                                {"id":2,"name":"B"}
                                                ]
                                            }
                                        }
                        """)));

        // Stubbing numbers endpoint for EmployeeById
        wireMockServer.stubFor(
                post("/")
                        .withRequestBody(matchingJsonPath("$.query",containing("employeeById")))
                        .withRequestBody(matchingJsonPath("$.variables.id", equalTo("1")))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBody("""
                                        {
                                            "data": {
                                            "employeeById": {"id":1,"name":"A"}
                                           }
                                        }
                                        """)));

        // Stubbing greet graphql endpoint
        wireMockServer.stubFor(
                post("/")
                        .withRequestBody(matchingJsonPath("$.query",containing("greet")))
                        .withRequestBody(matchingJsonPath("$.variables.userName", equalTo("John")))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBody("{\"data\": {\"greet\": \"Hello John\"}}")));

        return Map.of(
                "quarkus.rest-client.number-ms.url", wireMockServer.baseUrl(),
                "quarkus.smallrye-graphql-client.greet-ms.url", wireMockServer.baseUrl()
        );
    }

    @Override
    public void stop() {
        if (nonNull(wireMockServer)) {
            wireMockServer.stop();
        }
    }
}