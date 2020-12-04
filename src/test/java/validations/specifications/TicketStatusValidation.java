package validations.specifications;

import Utils.ServiceRequest;
import validations.structure.CompositeSpecification;
import validations.structure.ReturnSpecification;

public class TicketStatusValidation extends CompositeSpecification<ServiceRequest> {

    private static final String ERROR_MESSAGE = "Ticket Status did not match.";
    private String status;
    public TicketStatusValidation(String status){
        this.status = status;
    }
    @Override
    public ReturnSpecification isSatisfiedBy(ServiceRequest request){
        System.out.println("Actual " + request.getStatusDescription());
        System.out.println("Expected " + status);
        if(!request.getStatusDescription().equals(status)){
            returnSpecification.setMessage(ERROR_MESSAGE);
        }
        return returnSpecification;
    }
}