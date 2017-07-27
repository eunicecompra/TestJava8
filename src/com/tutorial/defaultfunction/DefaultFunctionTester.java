package com.tutorial.defaultfunction;

public class DefaultFunctionTester {
    public static void main (String [] args) {
        Fruit apple = new Apple();
        apple.printName();

    }
}

interface Fruit {
    default void printName() {
        System.out.println("I am just your ordinary fruit.");
    }
}

interface Tree {
    default void printName() {
        System.out.println("I am just your ordinary tree.");
    }
}

class Apple implements Fruit, Tree {
    public void printName() {
        Fruit.super.printName();
        Tree.super.printName();
        System.out.println("I am an apple.");
    }
}
