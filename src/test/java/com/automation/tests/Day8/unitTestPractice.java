package com.automation.tests.Day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class unitTestPractice {

    public static void main(String[] args) {

        // unit test is to check
            String expected = "cba";
            String toReverse = "abc";
            String actual = reverseString(toReverse);
            // Assertion
            verifyEquals(expected,actual);

        }

        @Test  (description = "verify if method can reverse a String")
        // ---> annotation, its from testNG. when we use this, we don't need to use main method.

        public void test(){
        String expected = "elppa";
        String actual = reverseString("apple");

             // it coming from testNG, Junit also has this class
            // you can compare any data type here, Strings, primitives, arrays, objects
            // to verify expected result equals to actual

            Assert.assertEquals(actual,expected);
        }
        @Test(description = "verify if method can reverse a String")
        public void test2(){
        String expected ="";

        }



        public static boolean verifyEquals(String expected, String actual) {
            if (expected.equals(actual)) {
                System.out.println("TEST PASSED");
                return true;

            } else {
                System.out.println("Test failed!!!");
                System.out.println("Expected: " + expected);
                System.out.println("Actual: " + actual);
                return false;
            }
        }

        /**
         * This method stands for reversing strings.
         *
         * @param str to reverse
         * @return reversed string
         */

        public static String reverseString(String str) {
            String reversed = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                reversed += str.charAt(i);
            }
            return reversed;
        }
    }



