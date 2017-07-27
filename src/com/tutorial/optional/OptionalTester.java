package com.tutorial.optional;

import java.util.Optional;

public class OptionalTester {

    public static void main (String[] args) {
        OptionalTester test = new OptionalTester();
        House house;
        Kitchen kitchen;

        //Complete House
        System.out.println("A fully-furnished house:");
        house = new House();
        kitchen = new Kitchen();
        kitchen.setOven(Optional.of(new Oven("Electrolux")));
        house.setKitchen(Optional.of(kitchen));

        test.printOvenDetails(house);

        //House with no oven
        System.out.println("\nAn unfurnished house:");
        house = new House();
        kitchen = new Kitchen();
        house.setKitchen(Optional.of(kitchen));

        test.printOvenDetails(house);

    }

    private void printOvenDetails(House house) {
        String ovenBrand = Optional.of(house).flatMap(House::getKitchen)
                .flatMap(Kitchen::getOven)
                .map(Oven::getBrand)
                .orElse("Unknown");
        System.out.println("The oven in the house is by " + ovenBrand + ".");
    }
}

class House {
    private Optional<Kitchen> kitchen;

    public House() {
        kitchen = Optional.ofNullable(null);
    }

    public Optional<Kitchen> getKitchen() {
        return kitchen;
    }

    public void setKitchen(Optional<Kitchen> kitchen) {
        this.kitchen = kitchen;
    }

}

class Kitchen {
    private Optional<Oven> oven;

    public Kitchen() {
        oven = Optional.ofNullable(null);
    }

    public Optional<Oven> getOven() {
        return oven;
    }

    public void setOven(Optional<Oven> oven) {
        this.oven = oven;
    }
}

class Oven {
    private String brand;

    public Oven (String brand) {
        setBrand(brand);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

