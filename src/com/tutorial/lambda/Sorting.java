package com.tutorial.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting {

    public static void main (String[] args) {
        List<String> stringList = Arrays.asList("Quick","Brown","Fox");
        System.out.println("Before sorting: " + stringList);
        Collections.sort(stringList, (string1, string2) -> string1.compareTo(string2));
        System.out.println("After sorting:" + stringList);
    }
}
