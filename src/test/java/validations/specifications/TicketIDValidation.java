package validations.specifications;

import Utils.ServiceRequest;
import validations.structure.CompositeSpecification;
import validations.structure.ReturnSpecification;

public class TicketIDValidation extends CompositeSpecification<ServiceRequest> {

    private static String ERROR_MESSAGE = "Ticket Id did not match.";
    private String id;
    public TicketIDValidation(String id){
        this.id = id;
    }
    @Override
    public ReturnSpecification isSatisfiedBy(ServiceRequest request){
        if(!request.getId().equals(id)){
            returnSpecification.setMessage(ERROR_MESSAGE);
        }
        return returnSpecification;
    }
}
