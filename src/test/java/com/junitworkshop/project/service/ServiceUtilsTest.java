package com.junitworkshop.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Testing Date changes ")
public class ServiceUtilsTest {

    private ServiceUtils utils;
@BeforeEach
    void SetupService(){
     utils = new ServiceUtils();
    }


    @DisplayName("Testing correct no monday")
    @ParameterizedTest
    @MethodSource("DateSuccessNoMonday")
    void dateFormatter_Correct_Input_Should_Add_6Days_Test(String testedDate, String expectedDate) throws DateTimeException{

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeZone timeZone = DateTimeZone.forID("America/New_York");


        DateTime dateTimeMock = formatter.withZone(timeZone).parseDateTime(testedDate);
        DateTime dateTimeExpected = formatter.withZone(timeZone).parseDateTime(expectedDate);


        DateTime actualDate = utils.dateFormattter(dateTimeMock);
        assertEquals(dateTimeExpected, actualDate,"error");
    }



@Test
@DisplayName("Wrong timezone exception")
void dateFormatterIncorrectDateZoneThrowsDateTimeException (){

    DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    DateTimeZone timeZone = DateTimeZone.forID("America/Mexico_City");
    String testedDate= "2024-01-10 20:01:01";
    String timeZoneString = timeZone.toString();

    DateTime dateTimeMock = formatter.withZone(timeZone).parseDateTime(testedDate);


    Assertions.assertThrows(DateTimeException.class,()-> utils.dateFormattter(dateTimeMock),timeZoneString+" timezoned should have thrown an exception");

}

    @Disabled //Please work on this TEST IT IS BREAKING
    @Test
    void ExampleOfDisabledTest(){
        System.out.println("not good practice but good to know anyways ");
    }


    @DisplayName("Testing correct monday")
    @ParameterizedTest
    @MethodSource("DateSuccessMonday")
    void dateFormatter_Correct_Input_Should_Add_2Hours_Test(String testedDate, String expectedDate) throws DateTimeException{

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeZone timeZone = DateTimeZone.forID("America/New_York");


        DateTime dateTimeMock = formatter.withZone(timeZone).parseDateTime(testedDate);
        DateTime dateTimeExpected = formatter.withZone(timeZone).parseDateTime(expectedDate);


        DateTime actualDate = utils.dateFormattter(dateTimeMock);
        assertEquals(dateTimeExpected, actualDate,"error");
    }

    private static Stream<Arguments> DateSuccessNoMonday(){
        return Stream.of(
                Arguments.of("2024-01-10 20:01:01", "2024-01-16 00:00:00"),
                Arguments.of("2024-07-16 20:01:01", "2024-07-22 00:00:00"),
                Arguments.of("2024-07-30 20:01:01", "2024-08-05 00:00:00")
        );
    }


    private static Stream<Arguments> DateSuccessMonday(){
        return Stream.of(
                Arguments.of("2024-07-22 00:01:01", "2024-07-22 02:01:01"),
                Arguments.of("2024-07-22 20:01:01", "2024-07-22 22:01:01"),
                Arguments.of("2024-07-22 23:01:01", "2024-07-23 01:01:01")
        );
    }
}
