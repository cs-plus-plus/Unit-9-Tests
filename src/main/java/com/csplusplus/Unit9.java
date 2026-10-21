package com.csplusplus;

/**
 * Unit 9: Inheritance — demonstrates extends, super, method overriding,
 * abstract classes and methods, and interfaces.
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
    // GROUP 4: Shape (abstract class) + Resizable (interface) → Square
    // ═══════════════════════════════════════════════════════════════════════

    /**
     * Resizable is an INTERFACE: a list of methods that every class which
     * "implements Resizable" promises to have. Interface methods have no body.
     *
     * <p>You need to implement:</p>
     * <ul>
     *   <li>The method header {@code void scale(double factor);} (no body, just a semicolon)</li>
     * </ul>
     */
    public interface Resizable {
        // TODO: Declare the method  void scale(double factor);
    }

    /**
     * Shape is an ABSTRACT class. Nobody can create a {@code new Shape()}, but
     * other classes can extend it. Its abstract method area() has no body, so
     * every subclass must write its own.
     *
     * <p>Points: Part of 25-point test</p>
     *
     * <p>You need to implement:</p>
     * <ul>
     *   <li>Make the class abstract: {@code public static abstract class Shape}</li>
     *   <li>An abstract method {@code public abstract double area();} (no body)</li>
     *   <li>A describe() method that returns "Area: " + area()</li>
     * </ul>
     *
     * <p>Hint: describe() can call area() even though Shape never says how to
     * compute it. Java runs the subclass's area() when describe() is called.</p>
     */
    public static class Shape {
        // TODO: Add the abstract keyword to the class header above

        // TODO: public abstract double area();

        // TODO: describe() returns "Area: " + area()
    }

    /**
     * Square extends Shape AND implements Resizable.
     *
     * <p>Points: Part of 25-point test</p>
     *
     * <p>You need to implement:</p>
     * <ul>
     *   <li>A constructor Square(double side) that sets side</li>
     *   <li>area() returns side * side (Shape's abstract method)</li>
     *   <li>scale(double factor) multiplies side by factor (Resizable's method)</li>
     * </ul>
     *
     * <p>Hint: Java will not compile Square until it has BOTH area() and scale().
     * That is the promise "extends an abstract class" and "implements an
     * interface" makes.</p>
     */
    public static class Square extends Shape implements Resizable {
        private double side;

        // TODO: Constructor(double side)

        // TODO: area() returns side * side

        // TODO: scale(double factor) multiplies side by factor
    }
}
