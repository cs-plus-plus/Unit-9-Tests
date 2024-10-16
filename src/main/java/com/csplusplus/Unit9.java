package com.csplusplus;

public class Unit9 {
    
    // Person Class
    public static class Person {
        protected String name;

        // TODO: Create a constructor that accepts a String parameter and sets the name instance variable
        
        // TODO: Create a getter method to return the value of the name instance variable
    }

    // Employee Class that extends Person and uses super in constructor
    public static class Employee extends Person {
        private String jobTitle;

        // TODO: Create a constructor that accepts two parameters (name and jobTitle)
        // Call the parent constructor (Person) using super to set the name
        
        // TODO: Override the getName method to return "Employee: " followed by the name
        
        // TODO: Create a getter method to return the jobTitle
    }

    // Animal Class
    public static class Animal {
        protected String name;

        // TODO: Create a constructor that accepts a String parameter and sets the name instance variable
        
        // TODO: Create a method called makeSound that returns "Some sound"
    }

    // Dog Class that extends Animal and overrides method
    public static class Dog extends Animal {

        // TODO: Create a constructor that accepts a String parameter and uses super to set the name
        
        // TODO: Override the makeSound method to return "Bark"
        
        // TODO: Create a method called makeParentSound that calls the parent (Animal) makeSound method using super
    }

    // Vehicle Class
    public static class Vehicle {
        protected int speed;

        // TODO: Create a constructor that accepts an int parameter and sets the speed instance variable
        
        // TODO: Create a getter method to return the speed
    }

    // Car Class that extends Vehicle and uses its own and parent instance data
    public static class Car extends Vehicle {
        private String model;

        // TODO: Create a constructor that accepts two parameters (speed and model)
        // Call the parent constructor (Vehicle) using super to set the speed
        
        // TODO: Create a method called getDetails that returns a String in the format 
        // "Model: [model], Speed: [speed]" using both the model and the speed (from Vehicle)
    }

    // Calculator Class with static variable and method
    public static class Calculator {
        // TODO: Create a static variable called counter
        
        // TODO: Create a static method called add that accepts two int parameters
        // Increment the counter each time the method is called
        // Return the sum of the two parameters
    }
}
