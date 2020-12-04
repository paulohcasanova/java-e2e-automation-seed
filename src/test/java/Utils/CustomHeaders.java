package Utils;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomHeaders {
    private String CSRFToken;
    private Map<String, String> cookies;

    public CustomHeaders(String CSRFToken, Map<String, String> cookies){
        this.CSRFToken = CSRFToken;
        this.cookies = cookies;
    }
    public CustomHeaders(String CSRFToken){
        this.CSRFToken = CSRFToken;
        this.cookies = new HashMap<>();
    }
    public CustomHeaders(){
        this.cookies = new HashMap<>();
        this.CSRFToken = "";
    }

    public String getCSRFToken() {
        return CSRFToken;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void setCSRFToken(String CSRFToken) {
        this.CSRFToken = CSRFToken;
    }

    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }
}