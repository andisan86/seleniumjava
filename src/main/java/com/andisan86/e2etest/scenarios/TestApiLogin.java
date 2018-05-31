package com.andisan86.e2etest.scenarios;

import com.andisan86.e2etest.api.RequestLogin;
import com.andisan86.e2etest.utils.PropertyFactory;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndProxy;
import org.mockserver.integration.ClientAndServer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.mockserver.integration.ClientAndProxy.startClientAndProxy;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

/**
 * Test API Login
 *
 * @author Andi Santoso
 */
public class TestApiLogin {
    private ClientAndProxy proxy;
    private ClientAndServer mockServer;
    private String testBaseURI;
    private String testBasePath;
    private String testPayload;
    private PropertyFactory propertyFactory;

    /**
     * Start a mock server based on properties in <i>config.properties</i>
     */
    @BeforeTest
    public void beforeTest() {
        propertyFactory = new PropertyFactory();
        mockServer = startClientAndServer(propertyFactory.getValueInteger("test.mockserver.port"));
        proxy = startClientAndProxy(propertyFactory.getValueInteger("test.mockserver.proxy"));
        new MockServerClient(propertyFactory.getValueString("test.mockserver.host"), propertyFactory.getValueInteger("test.mockserver.port"))
                .when(
                        request()
                                .withMethod("POST")
                                .withPath(propertyFactory.getValueString("test.mockserver.path"))
                                .withBody(propertyFactory.getValueString("test.mockserver.logintest.payload"))
                )
                .respond(
                        response()
                                .withStatusCode(propertyFactory.getValueInteger("test.mockserver.logintest.response"))
                                .withCookie(
                                        "sessionId", propertyFactory.getValueString("test.mockserver.logintest.cookie")
                                )
                                .withHeader(
                                        "Location", propertyFactory.getValueString("test.mockserver.logintest.location")
                                )
                );
        testBaseURI = propertyFactory.getValueString("test.mockserver.protocol") + propertyFactory.getValueString("test.mockserver.host") + ":" + propertyFactory.getValueInteger("test.mockserver.port");
        testBasePath = propertyFactory.getValueString("test.mockserver.path");
        testPayload = propertyFactory.getValueString("test.mockserver.logintest.payload");
    }

    /**
     * Test Login APi
     * @param expectedResponseCode expected response code
     */
    @Parameters({"expectedResponseCode"})
    @Test
    public void testLogin(int expectedResponseCode) {
        RequestLogin requestLogin = new RequestLogin(testBaseURI, testBasePath);
        int actualStatusCode = requestLogin.post(testPayload).getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedResponseCode, actualStatusCode, "Incorrect status code");
        softAssert.assertAll();
    }

    /**
     * Stop mock server
     */
    @AfterTest
    public void afterTest() {
        proxy.stop();
        mockServer.stop();
    }
}
