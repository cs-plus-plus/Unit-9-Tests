package com.csplusplus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Unit9Test {
    
    // Test for super constructor and method
    @Test
    public void testSuperConstructorAndMethod() {
        Unit9.Employee emp = new Unit9.Employee("Alice", "Software Engineer");
        
        // Test superclass constructor and instance data
        assertEquals("Employee: Alice", emp.getName());
        
        // Test child class method and instance data
        assertEquals("Software Engineer", emp.getJobTitle());
    }
    
    // Test for method overriding and calling parent method
    @Test
    public void testMethodOverridingAndSuperMethod() {
        Unit9.Dog dog = new Unit9.Dog("Buddy");
        
        // Test overridden method
        assertEquals("Bark", dog.makeSound());
        
        // Test calling parent method
        assertEquals("Some sound", dog.makeParentSound());
    }

    // Test for using child and parent instance data
    @Test
    public void testChildAndParentInstanceData() {
        Unit9.Car car = new Unit9.Car(120, "Sedan");
        
        // Test accessing both parent and child instance data
        assertEquals("Model: Sedan, Speed: 120", car.getDetails());
    }

    // Test for static methods and variables
    @Test
    public void testStaticMethodAndVariable() {
        // Test static method
        assertEquals(5, Unit9.Calculator.add(2, 3));
        
        // Test static variable (counter increments)
        assertEquals(1, Unit9.Calculator.counter);
        
        // Call static method again and check counter
        Unit9.Calculator.add(10, 20);
        assertEquals(2, Unit9.Calculator.counter);
    }
}
