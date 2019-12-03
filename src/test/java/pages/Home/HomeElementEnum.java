package pages.Home;

public class HomeElementEnum {

    Boolean isDesktop;
    public HomeElementEnum(Boolean isDesktop){
        this.isDesktop = isDesktop;
    }

    public String LOGIN_BUTTON_ELEMENT(){
        return isDesktop ? "" : "";
    }
    public String USERNAME_INPUT_ELEMENT(){
        return isDesktop ? "" : "";
    }
    public String PASSWORD_INPUT_ELEMENT(){
        return isDesktop ? "" : "";
    }
}
