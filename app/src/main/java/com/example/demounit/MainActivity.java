package com.example.demounit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static boolean isLeapYearFirstCut(int year){
        boolean result;
        if (year % 4 == 0){
            result = true;
        }
        else{
            result=false;
        }
        return result;
    }

    public static boolean isLeapYearSecondCut(int year){
        boolean result;
        if (year % 100 == 0){
            result = false;
        }
        else if (year % 4 == 0){
            result = true;
        }
        else{
            result=false;
        }
        return result;
    }

    public static boolean isLeapYearThirdCut(int year){
        boolean result;
        if (year % 400 == 0) {
            result = true;
        }
        else if (year % 100 == 0){
            result = false;
        }
        else if (year % 4 == 0){
            result = true;
        }
        else{
            result=false;
        }
        return result;
    }

    public static boolean isLeapYearGregorianFirstTry(int year){
        boolean result;
        if (year >= 1753){
            result = true;
        }
        else if (year % 400 == 0) {
            result = true;
        }
        else if (year % 100 == 0){
            result = false;
        }
        else if (year % 4 == 0){
            result = true;
        }
        else {
            result=false;
        }

        return result;
    }

    public static boolean isLeapYearGregorianSecondTry(int year){
        boolean result;
        if (year < 1753){
            result = false;
        }
        else if (year % 400 == 0) {
            result = true;
        }
        else if (year % 100 == 0){
            result = false;
        }
        else if (year % 4 == 0){
            result = true;
        }
        else {
            result=false;
        }

        return result;
    }

    public static boolean isLeapYear(int year){

        /*
        * The isLeapYear method takes a year as input and determines whether it is a leap year
        * under English-American calendaring.
        *
        * Years divisible by 4 are usually leap years, except...
        *   years divisible by 100 are *not* leap years, even though they're divisible by 4, except...
        *     years divisible by 400 are leap years after all, even though they're divisible by 100.
        *
        * 2019: not a leap year (not divisible by 4)
        * 2020: leap year (divisible by 4)
        * 2100: not a leap year (divisible by 100)
        * 2000: leap year (divisible by 400)
        *
        * Also: the Gregorian calendar with leap years was not adopted by England (and its American
        * colonies) until mid-1752; so any year prior to 1752 is not a leap year. (This isn't really
        * true, but let's pretend it is to introduce a bug to be caught by testing.)
        *
        * */

        boolean result;

        /*  Any year zero or earlier is invalid; throw an exception */
        if (year < 1){
            throw new IllegalArgumentException(String.format("Invalid year value '%s'.", year));
        }

        /* Any valid year prior to 1953 is a pre-Gregorian, so call it a non-leap year */
        if (year < 1753){
            result = false;
        }
        else if (year % 400 == 0) {
            result = true;
        }
        else if (year % 100 == 0){
            result = false;
        }
        else if (year % 4 == 0){
            result = true;
        }
        else{
            result=false;
        }

        return result;
    }

    public static boolean isValidDate(int year, int month, int date_of_month){
        boolean date_is_valid = isValidYear(year) &
                isValidMonth(month) &
                isValidDateOfMonth(year, month, date_of_month);
        return date_is_valid;
    }


    public static boolean isValidYear(int year){
        boolean result = false;
        if (year >= 1){
            result=true;
        }
        return result;
    }

    public static boolean isValidMonth(int month){
        return ((1 <= month) & (month <= 12));
    }


    public static boolean isValidDateOfMonth(int year, int month, int date_of_month){
        boolean result;
        int[] number_of_days_in_month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31,30, 31};
        if (isLeapYear(year)){
            number_of_days_in_month[1] = 29;
        }
        int max_date = number_of_days_in_month[month-1];
        if (date_of_month <= max_date){
            result = true;
        }
        else{
            result = false;

        }
        return result;
    }

    public static int adder(int a, int b){
        return a + b;
    }

    public static double lame_sqrt(double x){
        int number_of_iterations = 10;
        double guess = x/2.0;
        double approximate_root = 0;
        for (int i = 1; i <= number_of_iterations; i++){
            approximate_root = x/guess;
            guess = (approximate_root + guess)/2.0;
            System.out.println("approximate_root:" + approximate_root);
        }
        return approximate_root;

    }
}
