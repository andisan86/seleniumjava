package com.andisan86.e2etest.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Sample API class to login to mock server
 *
 * @author Andi Santoso
 */
public class RequestLogin {
    private String baseURI;
    private String basePath;
    private static Logger LOGGER = LogManager.getLogger(RequestLogin.class);

    /**
     * Constructor
     * @param baseURI base URI
     * @param basePath base path
     */
    public RequestLogin(String baseURI, String basePath) {
        this.baseURI = baseURI;
        this.basePath = basePath;
    }

    /**
     * Post a request
     * @return response object
     */
    public Response post(String payload) {
        Response response;
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;
        try {
            response = RestAssured
                    .given()
                    .contentType(ContentType.JSON).body(payload)
                    .when()
                    .post("");
        } catch (Exception e) {
            LOGGER.error(e);
            throw new NullPointerException();
        }
        return response;
    }

    /**
     * Get base URI
     * @return base URI
     */
    public String getBaseURI() { return baseURI; }

    /**
     * Get base path
     * @return base path
     */
    public String getBasePath() {
        return basePath;
    }
}
