package com.example.demounit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testTypicalYears(){
        assertTrue(MainActivity.isLeapYear(2016));
        assertFalse(MainActivity.isLeapYear(2017));
        assertFalse(MainActivity.isLeapYear(2018));
        assertFalse(MainActivity.isLeapYear(2019));
        assertTrue(MainActivity.isLeapYear(2020));
        assertFalse(MainActivity.isLeapYear(2021));
        assertFalse(MainActivity.isLeapYear(2022));
        assertFalse(MainActivity.isLeapYear(2023));
    }

    @Test
    public void testCenturies(){
        assertFalse(MainActivity.isLeapYear(1600));
        assertFalse(MainActivity.isLeapYear(1700));
        assertFalse(MainActivity.isLeapYear(1800));
        assertFalse(MainActivity.isLeapYear(1900));
        assertTrue(MainActivity.isLeapYear(2000));
        assertFalse(MainActivity.isLeapYear(2100));
        assertFalse(MainActivity.isLeapYear(2200));
        assertFalse(MainActivity.isLeapYear(2300));
        assertTrue(MainActivity.isLeapYear(2400));
    }

    @Test
    public void testPreGregorian(){
        assertFalse(MainActivity.isLeapYear(1746));
        assertFalse(MainActivity.isLeapYear(1747));
        assertFalse(MainActivity.isLeapYear(1748));
        assertFalse(MainActivity.isLeapYear(1749));
        assertFalse(MainActivity.isLeapYear(1750));
        assertFalse(MainActivity.isLeapYear(1751));
        assertFalse(MainActivity.isLeapYear(1752));
        assertFalse(MainActivity.isLeapYear(1753));
        assertFalse(MainActivity.isLeapYear(1754));
        assertFalse(MainActivity.isLeapYear(1755));
        assertTrue(MainActivity.isLeapYear(1756)); /* First Gregorian leap year*/
        assertFalse(MainActivity.isLeapYear(1757));
        assertFalse(MainActivity.isLeapYear(1758));
        assertFalse(MainActivity.isLeapYear(1759));
        assertTrue(MainActivity.isLeapYear(1760));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBadYearZero(){
        MainActivity.isLeapYear(0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBadYearNegative(){
        MainActivity.isLeapYear(-1);
    }


    @Test
    public void testValidYear(){
        assertTrue(MainActivity.isValidYear(2020));
        assertTrue(MainActivity.isValidYear(1));
        assertFalse(MainActivity.isValidYear(0));
        assertFalse(MainActivity.isValidYear(-1));
    }

    @Test
    public void testValidMonthSimple(){
        assertTrue(MainActivity.isValidMonth(12));
        assertFalse(MainActivity.isValidMonth(13));
    }

    @Test
    public void testValidMonthFancy(){
        int[] good_months_to_test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] bad_months_to_test = {0, 13, -1, 100, 42, 365};
        for (int month : good_months_to_test){
            assertTrue(MainActivity.isValidMonth(month));
        }
        for (int month : bad_months_to_test){
            assertFalse(MainActivity.isValidMonth(month));
        }

        assertTrue(MainActivity.isValidMonth(12));
        assertFalse(MainActivity.isValidMonth(13));
    }

    @Test
    public void testValidDateOvMonth(){
        assertTrue(MainActivity.isValidDateOfMonth(2020, 2, 1));
        assertTrue(MainActivity.isValidDateOfMonth(2020, 2, 28));
        assertTrue(MainActivity.isValidDateOfMonth(2020, 2, 29));
        assertFalse(MainActivity.isValidDateOfMonth(2020, 2, 30));
    }

    @Test
    public void testValidDate(){
        assertTrue(MainActivity.isValidDate(2020, 2, 1));
        assertTrue(MainActivity.isValidDate(2020, 2, 28));
        assertTrue(MainActivity.isValidDate(2020, 2, 29));
        assertFalse(MainActivity.isValidDate(2020, 2, 30));

        assertFalse(MainActivity.isValidDate(2021, 2, 29));
    }

    @Test
    public void testAdder(){
        assertEquals(MainActivity.adder(32, 10), 42);
        assertNotEquals(MainActivity.adder(64, -12), 42);
    }

    @Test
    public void testSqrt(){
        assertEquals(MainActivity.lame_sqrt(9.0), 3.0, 0.0001);
        assertEquals(MainActivity.lame_sqrt(10000.0), 100.0, 0.0001);
        assertEquals(MainActivity.lame_sqrt(2.0), 1.414, 0.001);
    }


}