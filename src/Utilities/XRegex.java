package Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XRegex {

    public static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern PHONE_REGEX = Pattern.compile("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", Pattern.CASE_INSENSITIVE);

    public static boolean checkNull(Object... args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("")) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkMail(String str) {
        Matcher m = EMAIL_REGEX.matcher(str);
        return m.matches();
    }

    public static boolean checkPhoneNumber(String str){
        Matcher m = PHONE_REGEX.matcher(str);
        return m.matches();
    }
    
}
