/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.helpers;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import sv.com.cormaria.servicios.entidades.archivo.TblProgramacionCitas;

/**
 *
 * @author romorales
 */
public class MonthDay implements Serializable{
    public static int MAX_SCHEDULE_SHOW = 5;
    private int day;
    private int dayOfWeek;
    private String dayOfWeekStr;
    private int month;
    private int year;
    private String monthStr;
    private String monthStrShort;
    private int selectedMonth;
    private Date dayDate;
    private int scheduleCount;
    private List<TblProgramacionCitas> citas = new ArrayList<TblProgramacionCitas>();

    public MonthDay(List<TblProgramacionCitas> citas, int scheduleCount) {
        this.citas = citas;
        this.scheduleCount = scheduleCount;
    }

    public MonthDay(int day, int dayOfWeek, String dayOfWeekStr, int month, int year, String monthStrShort, String monthStr, int selectedMonth, Date dayDate, List<TblProgramacionCitas> citas, int scheduleCount) {
        this.day = day;
        this.dayDate = dayDate;
        this.monthStr = monthStr;
        this.monthStrShort = monthStrShort;
        this.dayOfWeek = dayOfWeek;
        this.dayOfWeekStr = dayOfWeekStr;
        this.month = month;
        this.year = year;
        this.selectedMonth = selectedMonth;
        this.scheduleCount = scheduleCount;
        this.citas = citas;
    }
    
    public void addCount(){
        this.scheduleCount++;
    }

    public List<TblProgramacionCitas> getCitas() {
        return citas;
    }

    public void setCitas(List<TblProgramacionCitas> citas) {
        this.citas = citas;
    }

    public int getScheduleCount() {
        return scheduleCount;
    }

    public void setScheduleCount(int scheduleCount) {
        this.scheduleCount = scheduleCount;
    }
    
    public int getSelectedMonth() {
        return selectedMonth;
    }

    public void setSelectedMonth(int selectedMonth) {
        this.selectedMonth = selectedMonth;
    }
    
    public String getMonthStr() {
        return monthStr;
    }
    
    public boolean isFirstDayOfMonth(){
        return day == 1;
    }

    public Date getDayDate() {
        return dayDate;
    }

    public String getDayDateStr() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(dayDate);
    }

    public void setDayDate(Date dayDate) {
        this.dayDate = dayDate;
    }

    public boolean isLastDayOfMonth(){
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        return day == cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public void setMonthStr(String monthStr) {
        this.monthStr = monthStr;
    }

    public String getMonthStrShort() {
        return monthStrShort;
    }

    public void setMonthStrShort(String monthStrShort) {
        this.monthStrShort = monthStrShort;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDayOfWeekStr() {
        return dayOfWeekStr;
    }

    public void setDayOfWeekStr(String dayOfWeekStr) {
        this.dayOfWeekStr = dayOfWeekStr;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
