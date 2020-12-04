package validations.structure;

import org.junit.platform.commons.util.StringUtils;

public class ReturnSpecification {
    private String message;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Boolean getIsValid() {
        if(StringUtils.isBlank(getMessage())) System.out.println(getMessage());
        return StringUtils.isBlank(getMessage());
    }
}
