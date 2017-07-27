package com.tutorial.lambda;

public class InterfaceTester {

    public static void main (String[] args) {
        Animal dog = sound -> System.out.println("Dog: " + sound);
        Animal cat = sound -> System.out.println("Cat: " + sound);
        Animal cow = sound -> System.out.println("Cow: " + sound);

        dog.makeNoise("Woof woof!");
        cat.makeNoise("Meow meow...");
        cow.makeNoise("Baa baa...");
    }

    interface Animal {
        void makeNoise(String sound);
    }
}
