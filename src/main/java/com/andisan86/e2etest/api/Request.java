package com.andisan86.e2etest.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;

public class Request {
    private String baseURI;
    private String basePath;
    private static Logger LOGGER = LogManager.getLogger(RequestLogin.class);

    /**
     * Constructor
     * @param baseURI base URI
     * @param basePath base path
     */
    public Request(String baseURI, String basePath) {
        this.baseURI = baseURI;
        this.basePath = basePath;
    }

    /**
     * Post a request with JSON payload
     *
     * @param payload JSON payload
     * @return response object
     */
    public Response postJsonPayload(String payload) {
        Response response;
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;
        try {
            response = RestAssured
                    .given()
                    .header("X-Requested-With", "XMLHttpRequest")
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
     * Post a request with query parameters
     *
     * @param params query parameters
     * @return response object
     */
    public Response postQueryParam(Map<String, String> params) {
        Response response;
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;
        try {
            response = RestAssured
                    .given()
                    .header("X-Requested-With", "XMLHttpRequest")
                    .queryParams(params)
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
