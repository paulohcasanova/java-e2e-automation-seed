package validations;

import constants.api;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestBase {

    private RequestSpecification requestSpecification;

    protected RequestBase defineRequestSpecification(String url, String credentials) {
        String[] splitCredentials = credentials.split(":");
        this.requestSpecification = given()
                .baseUri(url)
                .auth().preemptive().basic(splitCredentials[0], splitCredentials[1])
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
        return this;
    }

    protected RequestBase defineRequestSpecification(String url, String credentials, HashMap<String, String> headers) {
        defineRequestSpecification(url, credentials);
        this.requestSpecification = requestSpecification.headers(headers);
        return this;
    }

    protected Response getRequestResponse() {
        return requestSpecification.when()
                .get()
                .then()
                .assertThat().statusCode(200)
                .extract().response();
    }

    protected String getRequestResponseAsString() {
        return requestSpecification.when()
                .get()
                .then()
                .assertThat().statusCode(200)
                .extract().asString();
    }

    protected void patchRequestWithHeaders(Map<String, String> cookies) {
        requestSpecification
                .cookies(cookies)
                .body(api.fetchJSONBody())
                .when()
                .patch()
                .then()
                .assertThat().statusCode(204);
    }
}
