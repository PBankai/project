package com.junitworkshop.project.service;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class ServiceUtils {
    
    public DateTime dateFormattter(DateTime datetimeUTC) throws DateTimeException{
       DateTimeZone actualZone = datetimeUTC.getZone();
       DateTimeZone timeZonerequired = DateTimeZone.forID("America/New_York");
        if (actualZone!= timeZonerequired){
            throw new DateTimeException("This date wasn't got in the correct TimeZone");
        }
        else {
            if(datetimeUTC.dayOfWeek().get()==1){
                return datetimeUTC.plusHours(2);
            }else {
                return datetimeUTC.plusDays(6).withTimeAtStartOfDay();
            }
        }
    }
}
