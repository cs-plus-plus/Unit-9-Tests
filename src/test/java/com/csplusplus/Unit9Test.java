package com.csplusplus;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class Unit9Test {

    @Test
    @DisplayName("testSuperConstructorAndMethod: Employee extends Person with super (25 points)")
    public void testSuperConstructorAndMethod() {
        Unit9.Employee emp = new Unit9.Employee("Alice", "Software Engineer");
        assertAll("Super Constructor & Method Override",
            () -> assertEquals("Employee: Alice", emp.getName(),
                "emp.getName() should return \"Employee: Alice\". Override getName() to prepend \"Employee: \""),
            () -> assertEquals("Software Engineer", emp.getJobTitle(),
                "emp.getJobTitle() should return \"Software Engineer\"")
        );
    }

    @Test
    @DisplayName("testMethodOverridingAndSuperMethod: Dog overrides Animal.makeSound (25 points)")
    public void testMethodOverridingAndSuperMethod() {
        Unit9.Dog dog = new Unit9.Dog("Buddy");
        assertAll("Method Overriding & super Method Call",
            () -> assertEquals("Bark", dog.makeSound(),
                "dog.makeSound() should return \"Bark\" (overridden method)"),
            () -> assertEquals("Some sound", dog.makeParentSound(),
                "dog.makeParentSound() should return \"Some sound\" (calls super.makeSound())")
        );
    }

    @Test
    @DisplayName("testChildAndParentInstanceData: Car uses Vehicle's speed + own model (25 points)")
    public void testChildAndParentInstanceData() {
        Unit9.Car car = new Unit9.Car(120, "Sedan");
        assertEquals("Model: Sedan, Speed: 120", car.getDetails(),
            "car.getDetails() should return \"Model: Sedan, Speed: 120\"");
    }

    @Test
    @DisplayName("testStaticMethodAndVariable: Calculator static add and counter (25 points)")
    public void testStaticMethodAndVariable() {
        assertAll("Static Method & Variable",
            () -> assertEquals(5, Unit9.Calculator.add(2, 3),
                "Calculator.add(2, 3) should return 5"),
            () -> assertEquals(1, Unit9.Calculator.counter,
                "After one add() call, counter should be 1"),
            () -> {
                Unit9.Calculator.add(10, 20);
                assertEquals(2, Unit9.Calculator.counter,
                    "After two add() calls, counter should be 2");
            }
        );
    }
}
