package Utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class ServiceRequest {

    private String id;

    @JsonProperty("Name")
    private String name;

    private String statusCode;

    @JsonProperty("StatusDescription")
    private String statusDescription;

    private LocalDateTime creationDate;

    private LocalDateTime closeDate;

    public ServiceRequest() {}

    public ServiceRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getStatusCode() {
        return statusCode;
    }

    @JsonProperty("StatusCode")
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @JsonIgnore
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @JsonIgnore
    public LocalDateTime getCloseDate() {
        return closeDate;
    }

    @JsonProperty("ResolvedOnDateTime")
    public void setCloseDate(LocalDateTime closeDate) {
        this.closeDate = closeDate;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonProperty("ID")
    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    public String getStatusDescription() {
        return statusDescription;
    }

    @JsonProperty("StatusDescription")
    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

}

