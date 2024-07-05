package com.zipcodewilmington;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {

        return array[0];
    }


    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {

        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {

        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String [] reversedArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }

        return reversedArray;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
//      Initialize left vs right array

        int left = 0;
        int right = array.length - 1;

//        check if right and left are equal
        while (right > left) {
            if (!array[right].equals(array[left])) {
                return false;
            }
//        compare a score if left and right are equal
            right--;
            left++;
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        boolean[] alphalist = new boolean[26];

        for (String str : array) {
            for (int i = 0; i < str.length(); i++) {
                char ch = Character.toLowerCase(str.charAt(i));
                if('a' <= ch && ch <= 'z') {
                    alphalist[ch - 'a'] = true;
                }
            }
        }

        for (boolean value : alphalist) {
            if(!value) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;

        // iterate each index through array

        for (String str : array) {
            if (str.equals(value)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        //Initializing a count to iterate  through an array to find occurrences of valueToRemove
        int count = 0;


        for (String str : array) {
            if (!str.equals(valueToRemove)) {
                count++;
            }
        }

        //create new array with adjusted size (from previous iteration based on count of non-matching elements)
        String[] resultArray = new String [count];
        int index = 0;

        //copy non-matching elements to newly created array
        for (String str : array) {
            if (!str.equals(valueToRemove)) {
                resultArray[index++] = str;
            }
        }

        return resultArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        // start by listening non-duplicates, creating a new list:
        List<String> nonDuplicateList = new ArrayList<>();

        //taking the first character to compare
        nonDuplicateList.add(String.valueOf(array[0]));

        //Iterate through an array to pull the second character
        for (int i = 1; i < array.length; i++) {
            //compare both of the characters we check for
            if (array[i] != array[i - 1]) {
                nonDuplicateList.add(String.valueOf(array[i]));
            }
        }
        //convert list to array
        return nonDuplicateList.toArray(new String[0]);

    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        // start by listening non-duplicates, creating a new list:
        List<String> packConsecDupsList = new ArrayList<>();

        //implementing string builder to build each string sequence
        StringBuilder sb = new StringBuilder();

        //initialize the first string sequence
        sb.append(array[0]);

        //iterate through the array from second element
        for (int i = 1; i < array.length; i++) {
            if (array[i].equals(array[i-1])) {
                //append to the sequence we created above
                sb.append(array[i]);
            } else {
                //add current sequence to the packConsecDups list
                packConsecDupsList.add(sb.toString());
                sb.setLength(0);
                sb.append(array[i]);
            }
        }
        // add the last sequence to the packConsecDups lsit
        packConsecDupsList.add(sb.toString());

        //convert list back to array and return
        return packConsecDupsList.toArray(new String[0]);
    }
}
