package com.csplusplus;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Modifier;
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
    @DisplayName("testAbstractClassAndInterface: Square extends abstract Shape and implements Resizable (25 points)")
    public void testAbstractClassAndInterface() {
        assertAll("Abstract Class, Abstract Method & Interface",
            () -> assertTrue(Modifier.isAbstract(Unit9.Shape.class.getModifiers()),
                "Shape should be an abstract class: public static abstract class Shape"),
            () -> assertTrue(isAbstractMethod(Unit9.Shape.class, "area"),
                "Shape should declare area() as an abstract method with no body: public abstract double area();"),
            () -> assertTrue(Unit9.Resizable.class.isInterface(),
                "Resizable should be an interface"),
            () -> {
                Unit9.Shape shape = new Unit9.Square(3);   // a Square IS-A Shape
                assertEquals(9.0, shape.area(), 0.0001,
                    "new Square(3).area() should return 9.0 (side * side)");
                assertEquals("Area: 9.0", shape.describe(),
                    "describe() should return \"Area: \" + area(), so a Square with side 3 gives \"Area: 9.0\"");
            },
            () -> {
                Unit9.Square square = new Unit9.Square(2);
                Unit9.Resizable resizable = square;        // a Square IS-A Resizable
                resizable.scale(3);
                assertEquals(36.0, square.area(), 0.0001,
                    "After scale(3), a Square with side 2 should have side 6 and area 36.0");
            }
        );
    }

    /** True when cls itself declares a no-argument method with this name and it is abstract. */
    private static boolean isAbstractMethod(Class<?> cls, String name) {
        try {
            return Modifier.isAbstract(cls.getDeclaredMethod(name).getModifiers());
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
}
