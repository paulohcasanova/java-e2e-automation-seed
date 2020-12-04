package constants;

public class api {
    private static String apiURL = "";
    private static String JSON_BODY = "json body structure";
    private static String GET = "";
    private static String PATCH = "";
    private static String ALL_TICKETS = "";

    private static String CUSTOM_MAIN_URL = "";

    public static String fetchMainCustomURL() { return CUSTOM_MAIN_URL;}

    public static String fetchGETUrl(String ticket){
        return apiURL + GET;
    }
    public static String fetchPatchUrl(String ticket){
        return apiURL + PATCH;
    }
    public static String fetchAllTickets(){
        return apiURL + ALL_TICKETS;
    }
    public static String fetchJSONBody(){
        return JSON_BODY;
    }
    public static String fetchMainUrl(){
        return apiURL;
    }
}