
package Utilities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class XDate {
    
    static  SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
    
    public static Date toDate(String date){
        try {
            return (Date) formater.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String toString(Date date){
        return formater.format(date);
    }
    
    public static Date now() {
        return new Date();
    }
    
    public static  Date addDays(Date date, int days){
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH,days);
        return (Date) cal.getTime();
    }
    
    public static Date add(int days){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH,days);
        return cal.getTime();
    }
}
