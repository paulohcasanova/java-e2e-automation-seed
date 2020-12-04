package validations;

import Utils.CustomHeaders;
import Utils.ServiceRequestResponse;
import constants.api;
import io.restassured.response.Response;

import java.net.*;
import java.util.HashMap;
import Utils.CRUD.ServiceRequest;

import static Utils.CommonMethods.toObject;

public class APIRequests extends RequestBase {

    private final String CREDENTIALS = "API_USER:Password!";//System.getProperty("Credentials");

    private CustomHeaders customHeaders;

    public APIRequests(){
        this.customHeaders = new CustomHeaders();
    }

    //region GET
    public String submitGetRequest(String ticketNumber){
        return defineRequestSpecification(api.fetchGETUrl(ticketNumber), CREDENTIALS)
                .getRequestResponseAsString();
    }
    public String getTicketInOpenStatus(){
        return defineRequestSpecification(api.fetchAllTickets(), CREDENTIALS)
                .getRequestResponseAsString();
    }

    //endregion

    //region PATCH
    public String updateTicketToInProgress(String response){
        String id = "";
        try{
            ServiceRequestResponse json = toObject(
                    response,
                    ServiceRequestResponse.class);

            ServiceRequest result = json.getD().getServiceResults().get(0);
            id = result.getId();

            createCustomHeaders(defineRequestSpecification(api.fetchMainUrl(), CREDENTIALS,
                    tokenCustomHeaders()).getRequestResponse());

            String patchUrl = api.fetchPatchUrl(URLEncoder.encode("('" + id + "')", "UTF-8"));
            defineRequestSpecification(patchUrl, CREDENTIALS, patchCustomHeaders())
                    .patchRequestWithHeaders(customHeaders.getCookies());
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }
    //endregion

    //region Header Builder
    private HashMap<String,String> tokenCustomHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("X-CSRF-Token", "fetch");
        return headers;
    }
    private HashMap<String,String> patchCustomHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("X-CSRF-Token", customHeaders.getCSRFToken());
        return headers;
    }
    //endregion

    //region Helpers
    private void createCustomHeaders(Response res) {
        customHeaders.setCSRFToken(res.getHeader("x-csrf-token"));
        customHeaders.setCookies(res.getCookies());
    }
    //endregion
}
