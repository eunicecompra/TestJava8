package com.tutorial.methodref;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTester {
    public static void main (String[] args) {
        List<String> travelPlaces = new ArrayList<>();
        travelPlaces.add("Easter Island");
        travelPlaces.add("Antarctica");
        travelPlaces.add("Mongolia");
        travelPlaces.add("Tibet");
        travelPlaces.add("Iceland");

        travelPlaces.forEach(System.out::println);

    }
}
