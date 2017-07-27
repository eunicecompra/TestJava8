package com.tutorial.functionalintf;

import java.util.HashMap;
import java.util.function.Predicate;

public class PredicateTester {
    public static void main (String[] args) {
        HashMap<String,String> moviesMap = new HashMap<>();
        moviesMap.put("La Haine","French");
        moviesMap.put("We Bought a Zoo","English");
        moviesMap.put("Volver","Spanish");
        moviesMap.put("Wonderwoman","English");
        moviesMap.put("Amelie","French");

        PredicateTester predicateTester = new PredicateTester();

        System.out.println("Watching English movies:");
        predicateTester.watchMovie(moviesMap,language -> language.equals("English"));

        System.out.println("Watching French movies:");
        predicateTester.watchMovie(moviesMap,language -> language.equals("French"));

        System.out.println("Watching Spanish movies:");
        predicateTester.watchMovie(moviesMap,language -> language.equals("Spanish"));

        System.out.println("Watching all movies:");
        predicateTester.watchMovie(moviesMap,language -> true);

    }

    private void watchMovie(HashMap<String,String> moviesMap, Predicate<String> stringPredicate) {
        for ( String movie : moviesMap.keySet() ) {
            String lang = moviesMap.get(movie);
            if ( stringPredicate.test(lang) ) {
                System.out.println(movie);
            }
        }
    }
}
