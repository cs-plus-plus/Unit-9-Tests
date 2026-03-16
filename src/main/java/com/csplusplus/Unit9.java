package com.csplusplus;

/**
 * Unit 9: Inheritance — demonstrates extends, super, method overriding,
 * and static methods/variables.
 */
public class Unit9 {

    public static void main(String[] args) {
        // Test your classes here
        // Example: test Employee (after implementing Person and Employee)
        // Employee emp = new Employee("Alice", "Software Engineer");
        // System.out.println("emp.getName() = " + emp.getName());  // Expected: Employee: Alice
        // System.out.println("emp.getJobTitle() = " + emp.getJobTitle());  // Expected: Software Engineer
        System.out.println("Implement the classes below, then uncomment the test code above.");
    }

    // ═══════════════════════════════════════════════════════════════════════
    // PAIR 1: Person → Employee (super constructor + method override)
    // ═══════════════════════════════════════════════════════════════════════

    /**
     * A simple Person class with a name.
     *
     * <p>You need to implement:</p>
     * <ul>
     *   <li>A constructor that takes a String name and sets it</li>
     *   <li>A getName() method that returns the name</li>
     * </ul>
     */
    public static class Person {
        protected String name;

        // TODO: Create a constructor that accepts a String parameter and sets the name
        //       Example: new Person("Alice") → name = "Alice"

        // TODO: Create a getName() method that returns the name
    }

    /**
     * Employee extends Person. Demonstrates super constructor and method overriding.
     *
     * <p>Points: Part of 25-point test</p>
     *
     * <p>You need to implement:</p>
     * <ul>
     *   <li>A constructor(String name, String jobTitle) that calls super(name)</li>
     *   <li>Override getName() to return "Employee: " + name</li>
     *   <li>A getJobTitle() method</li>
     * </ul>
     *
     * <p>Hint: Use super(name) as the first line of the constructor.</p>
     */
    public static class Employee extends Person {
        private String jobTitle;

        // TODO: Constructor(String name, String jobTitle) — call super(name), set jobTitle

        // TODO: Override getName() to return "Employee: " + name

        // TODO: getJobTitle() returns the jobTitle
    }

    // ═══════════════════════════════════════════════════════════════════════
    // PAIR 2: Animal → Dog (method overriding + calling parent method)
    // ═══════════════════════════════════════════════════════════════════════

    /**
     * A simple Animal class with a name and sound.
     *
     * <p>You need to implement:</p>
     * <ul>
     *   <li>A constructor that takes a String name</li>
     *   <li>A makeSound() method that returns "Some sound"</li>
     * </ul>
     */
    public static class Animal {
        protected String name;

        // TODO: Constructor(String name)

        // TODO: makeSound() returns "Some sound"
    }

    /**
     * Dog extends Animal. Demonstrates method overriding and super method calls.
     *
     * <p>Points: Part of 25-point test</p>
     *
     * <p>Hint: super.makeSound() calls the Animal version.</p>
     */
    public static class Dog extends Animal {

        // TODO: Constructor(String name) using super(name)

        // TODO: Override makeSound() to return "Bark"

        // TODO: makeParentSound() returns super.makeSound()
    }

    // ═══════════════════════════════════════════════════════════════════════
    // PAIR 3: Vehicle → Car (parent + child instance data)
    // ═══════════════════════════════════════════════════════════════════════

    /**
     * A simple Vehicle class with a speed.
     */
    public static class Vehicle {
        protected int speed;

        // TODO: Constructor(int speed)

        // TODO: getSpeed() returns the speed
    }

    /**
     * Car extends Vehicle. Uses both parent and child instance data.
     *
     * <p>Points: Part of 25-point test</p>
     *
     * <p>getDetails() should return "Model: [model], Speed: [speed]"</p>
     */
    public static class Car extends Vehicle {
        private String model;

        // TODO: Constructor(int speed, String model) — call super(speed), set model

        // TODO: getDetails() returns "Model: [model], Speed: [speed]"
    }

    // ═══════════════════════════════════════════════════════════════════════
    // CLASS 4: Calculator (static methods and variables)
    // ═══════════════════════════════════════════════════════════════════════

    /**
     * Calculator class demonstrating static variables and methods.
     *
     * <p>Points: Part of 25-point test</p>
     *
     * <p>Hint: Static variables belong to the class, not instances.</p>
     */
    public static class Calculator {
        // TODO: public static int counter

        // TODO: static add(int a, int b) — increment counter, return a + b
    }
}
