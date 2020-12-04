package validations;

import Utils.ServiceRequestResponse;
import org.junit.Assert;
import Utils.ServiceRequest;
import validations.specifications.TicketIDValidation;
import validations.specifications.TicketStatusCodeValidation;
import validations.specifications.TicketStatusValidation;
import validations.structure.ReturnSpecification;

import static Utils.CommonMethods.toObject;


public class Validations {

    private Validations(){}
    public static Validations of(){ return new Validations();}

    public void validateFullResponse(String response, String ticketNum, String status, String description) throws Exception {
        ServiceRequestResponse json = toObject(
                response,
                ServiceRequestResponse.class);

        ServiceRequest result = json.getD().getServiceResults().get(0);

        ReturnSpecification validations =
                new TicketIDValidation(ticketNum)
                        .and(new TicketStatusCodeValidation(description))
                        .and(new TicketStatusValidation(status))
                        .isSatisfiedBy(result);

        Assert.assertTrue(validations.getIsValid());
        System.out.println("c4c validated");
    }
}
