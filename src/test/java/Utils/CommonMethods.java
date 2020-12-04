package Utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonMethods {

    public static String getMonthNum(String month) throws Exception {
        switch (month){
            case "JANUARY":
                return "01";
            case "FEBRUARY":
                return "02";
            case "MARCH":
                return "03";
            case "APRIL":
                return "04";
            case "MAY":
                return "05";
            case "JUNE":
                return "06";
            case "JULY":
                return "07";
            case "AUGUST":
                return "08";
            case "SEPTEMBER":
                return "09";
            case "OCTOBER":
                return "10";
            case "NOVEMBER":
                return "11";
            case "DECEMBER":
                return "12";
            default:
                throw new Exception("No such month");
        }
    }

    public static String getState(boolean state){
        if(state){
            return "Active";
        }else{
            return "Inactive";
        }
    }

    public static String randomString(){
        int count = 6;
        final String alpha_numeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0){
            int character = (int)(Math.random()*alpha_numeric.length());
            builder.append(alpha_numeric.charAt(character));
        }
        return builder.toString();
    }

    public static <T> T toObject(String json, Class<T> objectType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, objectType);
    }

    public static String randomNumAsString(int quant){
        //int count = 6;
        final String alpha_numeric = "0123456789";
        StringBuilder builder = new StringBuilder();
        while (quant-- != 0){
            int character = (int)(Math.random()*alpha_numeric.length());
            builder.append(alpha_numeric.charAt(character));
        }
        return builder.toString();
    }
}
