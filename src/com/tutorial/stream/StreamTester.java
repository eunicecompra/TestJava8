package com.tutorial.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTester {

    private List<Person> personList = new ArrayList<>();

    public static void main (String[] args) {
        StreamTester streamTester = new StreamTester();
        streamTester.initialisePersons();

        System.out.println("Searching for female persons aged 18 and above...");
        streamTester.searchPersons(param ->
            { return param.getAge() >= 18 &&
                param.getGender() == "Female";
            }
        );

        System.out.println("\nSearching for male persons aged 18 and above...");
        streamTester.searchPersons(param ->
                { return param.getAge() >= 18 &&
                        param.getGender() == "Male";
                }
        );

        System.out.println("\nSearching for all persons...");
        streamTester.searchPersons(param -> true);

    }

    private void searchPersons(Predicate<Person> param) {
        personList.stream().filter(param).collect(Collectors.toList()).forEach(System.out::println);
   }

    private void initialisePersons() {
        Person person = new Person ("John",23, "Male");
        personList.add(person);

        person = new Person ("Claire",18, "Female");
        personList.add(person);

        person = new Person ("Antonina",55, "Female");
        personList.add(person);

        person = new Person ("Michael",35, "Male");
        personList.add(person);

        person = new Person ("Sarah",17, "Female");
        personList.add(person);

        person = new Person ("Jane",28, "Female");
        personList.add(person);
    }

    class Person {
        String name;
        Integer age;
        String gender;

        public Person(String name, Integer age, String gender) {
            setName(name);
            setAge(age);
            setGender(gender);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String toString() {
            return "Name: " + this.name + ", " +
                    "Age: " + this.age + ", " +
                    "Gender: " + this.gender;
        }
    }
}
