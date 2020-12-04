package validations.specifications;

import Utils.ServiceRequest;
import validations.structure.CompositeSpecification;
import validations.structure.ReturnSpecification;

public class TicketStatusCodeValidation extends CompositeSpecification<ServiceRequest> {

    private static final String ERROR_MESSAGE = "Ticket Description did not match.";
    private String statusCode;
    public TicketStatusCodeValidation(String statusCode){
        this.statusCode = statusCode;
    }
    @Override
    public ReturnSpecification isSatisfiedBy(ServiceRequest request){
        if(!request.getStatusCode().equals(statusCode)){
            returnSpecification.setMessage(ERROR_MESSAGE);
        }
        return returnSpecification;
    }
}
