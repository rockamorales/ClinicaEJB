/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.helpers;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class DateUtils {
    public static int yearDateDiff(Date start, Date end){
           Calendar cal = Calendar.getInstance();
           cal.setTime(start);
           Calendar now = Calendar.getInstance();
           now.setTime(end);
           int birthDayMonth = cal.get(Calendar.MONTH);
           int nowMonth = now.get(Calendar.MONTH);
           int birthDayYear = cal.get(Calendar.YEAR);
           int nowYear = now.get(Calendar.YEAR);
           int yearsBetween = 0;
           if (nowMonth>birthDayMonth){
               yearsBetween = nowYear - birthDayYear - 1;
           }else{
               yearsBetween = nowYear - birthDayYear;
           }        
        return yearsBetween;
    }
}
