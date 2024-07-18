package com.junitworkshop.project.service;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
public class ServiceUtilsTest {
    
    @Test
    void dateFormattter_Correct_Input_Test() throws DateTimeException{
        ServiceUtils utils = new ServiceUtils();
        
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeZone timeZone = DateTimeZone.forID("America/New_York");
        DateTime dateTimeMock = formatter.withZone(timeZone).parseDateTime("2024-01-10 20:01:01");


        
        DateTime actualDate = utils.dateFormattter(dateTimeMock);
        
    }
}
