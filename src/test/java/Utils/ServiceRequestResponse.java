package Utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import Utils.CRUD.ServiceRequest;

public class ServiceRequestResponse {

    @JsonProperty("d")
    private D d;

    public ServiceRequestResponse() {}

    public ServiceRequestResponse(int count, List<ServiceRequest> results) {
        this.d = new D(count, results);
    }

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }

    public static class D {
        @JsonProperty("__count")
        private int count;

        @JsonProperty("results")
        private List<ServiceRequest> serviceResults;

        public List<ServiceRequest> getServiceResults() {
            return serviceResults;
        }

        public void setServiceResults(List<ServiceRequest> serviceResults) {
            this.serviceResults = serviceResults;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public D() {}

        public D(int count, List<ServiceRequest> serviceResults) {
            this.count = count;
            this.serviceResults = serviceResults;
        }
    }
}
