# CS++ Java — Unit 9: Inheritance

> **Unit 9** | 100 Points | 4 Autograded Tests

In this assignment you will use `extends`, the `super` keyword, method overriding with `@Override`, and work with parent/child class hierarchies. You will also write an abstract class with an abstract method, and an interface that a class implements.

---

## Table of Contents

1. [Concepts You Need](#concepts-you-need)
2. [Project Overview](#project-overview)
3. [Classes to Implement](#classes-to-implement)
4. [File Structure](#file-structure)
5. [Autograding](#autograding)
6. [Try It Yourself — Practice Examples](#try-it-yourself--practice-examples)
7. [Tips for Success](#tips-for-success)
8. [FAQ](#faq)

---

## Concepts You Need

### Inheritance (extends)

A child class inherits all public/protected methods and variables from a parent class:

```java
public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Dog extends Animal {
    public Dog(String name) {
        super(name);  // call the parent constructor
    }
}
```

### The `super` Keyword

- `super(args)` — calls the parent constructor (must be the first line in the child constructor)
- `super.methodName()` — calls the parent's version of an overridden method

```java
public class Dog extends Animal {
    public Dog(String name) {
        super(name);  // calls Animal(String name)
    }

    @Override
    public String makeSound() {
        return "Bark";
    }

    public String makeParentSound() {
        return super.makeSound();  // calls Animal's makeSound()
    }
}
```

### Method Overriding (@Override)

A child class can replace a parent's method with its own version:

```java
public class Animal {
    public String makeSound() {
        return "Some sound";
    }
}

public class Dog extends Animal {
    @Override
    public String makeSound() {
        return "Bark";  // replaces the parent's version
    }
}
```

### Abstract Classes and Abstract Methods

An `abstract` class can't be created with `new`. It exists to be extended. An `abstract` method has a header but no body, and every (non-abstract) subclass must write it:

```java
public abstract class Pet {
    public abstract String speak();       // no body: subclasses decide

    public String greet() {
        return "The pet says " + speak(); // calls the subclass's version
    }
}

public class Cat extends Pet {
    @Override
    public String speak() {
        return "Meow";
    }
}

// Pet p = new Pet();          // ERROR: Pet is abstract
Pet p = new Cat();
System.out.println(p.greet()); // The pet says Meow
```

### Interfaces

An `interface` is a list of method headers. A class that `implements` the interface promises to write every one of them. A class can extend ONE class but implement any number of interfaces:

```java
public interface Playable {
    void play();                // no body
}

public class Song implements Playable {
    @Override
    public void play() {
        System.out.println("Playing a song");
    }
}

Playable thing = new Song();    // a Song IS-A Playable
thing.play();                   // Playing a song
```

---

## Project Overview

You will implement four groups of classes inside `Unit9.java` as **static inner classes**. Each group demonstrates a different aspect of inheritance.

---

## Classes to Implement

### Group 1: Person and Employee (25 pts)

**Person class:**
- Constructor: `Person(String name)` — stores the name
- Method: `getName()` — returns the name

**Employee class (extends Person):**
- Constructor: `Employee(String name, String jobTitle)` — calls `super(name)`, stores jobTitle
- Override: `getName()` — returns `"Employee: "` followed by the name (e.g., `"Employee: Alice"`)
- Method: `getJobTitle()` — returns the job title

```java
Person p = new Person("Alice");
p.getName()                    // "Alice"

Employee e = new Employee("Bob", "Engineer");
e.getName()                    // "Employee: Bob"
e.getJobTitle()                // "Engineer"
```

### Group 2: Animal and Dog (25 pts)

**Animal class:**
- Constructor: `Animal(String name)` — stores the name
- Method: `makeSound()` — returns `"Some sound"`

**Dog class (extends Animal):**
- Constructor: `Dog(String name)` — calls `super(name)`
- Override: `makeSound()` — returns `"Bark"`
- Method: `makeParentSound()` — returns what the parent's `makeSound()` would return (using `super.makeSound()`)

```java
Animal a = new Animal("Cat");
a.makeSound()                  // "Some sound"

Dog d = new Dog("Rex");
d.makeSound()                  // "Bark"
d.makeParentSound()            // "Some sound"
```

### Group 3: Vehicle and Car (25 pts)

**Vehicle class:**
- Constructor: `Vehicle(int speed)` — stores the speed
- Method: `getSpeed()` — returns the speed

**Car class (extends Vehicle):**
- Constructor: `Car(int speed, String model)` — calls `super(speed)`, stores model
- Method: `getDetails()` — returns `"Model: [model], Speed: [speed]"`

```java
Vehicle v = new Vehicle(60);
v.getSpeed()                   // 60

Car c = new Car(120, "Tesla");
c.getSpeed()                   // 120 (inherited)
c.getDetails()                 // "Model: Tesla, Speed: 120"
```

### Group 4: Shape, Resizable and Square (25 pts)

**Resizable interface:**
- Declares one method: `void scale(double factor);` (no body)

**Shape class (abstract):**
- Make the class abstract: `public static abstract class Shape`
- Abstract method: `public abstract double area();` (no body)
- Method: `describe()` — returns `"Area: "` followed by `area()` (e.g., `"Area: 9.0"`)

**Square class (extends Shape, implements Resizable):**
- Constructor: `Square(double side)` — stores the side length
- `area()` — returns `side * side` (this fills in Shape's abstract method)
- `scale(double factor)` — multiplies `side` by `factor` (this is Resizable's method)

```java
Shape s = new Square(3);       // a Square IS-A Shape
s.area()                       // 9.0
s.describe()                   // "Area: 9.0"

Square sq = new Square(2);
Resizable r = sq;              // a Square IS-A Resizable
r.scale(3);                    // side is now 6
sq.area()                      // 36.0
```

The test also checks that `Shape` really is `abstract`, that `area()` is an abstract method, and that `Resizable` is an interface.

---

## File Structure

```
Unit-9-Tests/
├── pom.xml                                      <-- Maven config (DO NOT MODIFY)
├── src/
│   ├── main/java/com/csplusplus/
│   │   └── Unit9.java                           <-- YOUR CODE GOES HERE
│   └── test/java/com/csplusplus/
│       └── Unit9Test.java                       <-- Tests (DO NOT MODIFY)
└── .github/
    └── workflows/
        └── classroom.yml                        <-- Autograding (DO NOT MODIFY)
```

**Edit only `Unit9.java`.** All classes are defined as `public static` inner classes inside the `Unit9` class:

```java
public class Unit9 {
    public static class Person { ... }
    public static class Employee extends Person { ... }
    public static class Animal { ... }
    public static class Dog extends Animal { ... }
    public static class Vehicle { ... }
    public static class Car extends Vehicle { ... }
    public interface Resizable { ... }
    public static abstract class Shape { ... }
    public static class Square extends Shape implements Resizable { ... }
}
```

---

## Autograding

| Test | What It Checks | Points |
|------|---------------|--------|
| testSuperConstructorAndMethod | super constructor, getName override, getJobTitle | 25 |
| testMethodOverridingAndSuperMethod | makeSound override, makeParentSound calls super | 25 |
| testChildAndParentInstanceData | Inherited speed, getDetails format | 25 |
| testAbstractClassAndInterface | Shape and area() are abstract, Resizable is an interface, Square's area/describe/scale | 25 |

**Total: 100 points**

---

## Try It Yourself — Practice Examples

Create `Practice.java` in the same directory and run it with `javac Practice.java && java Practice`.

**Example 1 — Basic inheritance:**
```java
// Practice.java
public class Practice {
    static class Shape {
        private String type;
        public Shape(String type) { this.type = type; }
        public String getType() { return type; }
        public double area() { return 0; }
    }

    static class Circle extends Shape {
        private double radius;
        public Circle(double radius) {
            super("Circle");
            this.radius = radius;
        }
        @Override
        public double area() { return Math.PI * radius * radius; }
    }

    public static void main(String[] args) {
        Circle c = new Circle(5);
        System.out.println(c.getType());                         // Circle
        System.out.println("Area: " + String.format("%.2f", c.area())); // Area: 78.54
    }
}
```

**Example 2 — super.method():**
```java
// Practice.java
public class Practice {
    static class Base {
        public String greet() { return "Hello from Base"; }
    }

    static class Child extends Base {
        @Override
        public String greet() { return "Hello from Child"; }
        public String greetParent() { return super.greet(); }
    }

    public static void main(String[] args) {
        Child c = new Child();
        System.out.println(c.greet());        // Hello from Child
        System.out.println(c.greetParent());  // Hello from Base
    }
}
```

**Example 3 — Abstract class + interface:**
```java
// Practice.java
public class Practice {
    interface Chargeable {
        void charge(int minutes);
    }

    static abstract class Device {
        public abstract int battery();
        public String status() { return "Battery: " + battery() + "%"; }
    }

    static class Phone extends Device implements Chargeable {
        private int level = 20;
        @Override
        public int battery() { return level; }
        @Override
        public void charge(int minutes) { level = Math.min(100, level + minutes); }
    }

    public static void main(String[] args) {
        Phone p = new Phone();
        Device d = p;
        Chargeable c = p;
        System.out.println(d.status());  // Battery: 20%
        c.charge(30);
        System.out.println(d.status());  // Battery: 50%
    }
}
```

---

## Tips for Success

1. `super(args)` must be the **first line** in a child constructor
2. Use `@Override` annotation when overriding a method — it helps catch typos
3. Use `super.methodName()` to call the parent's version of an overridden method
4. All classes in this assignment are `static inner classes` of `Unit9`
5. An abstract method ends with a semicolon and has no `{ }` body: `public abstract double area();`
6. The `getDetails()` format must match exactly: `"Model: [model], Speed: [speed]"`

---

## FAQ

**Q: Why are these inner classes instead of separate files?**
The autograder expects all classes inside `Unit9.java`. Using `public static` inner classes lets you define multiple classes in one file.

**Q: What does `super(name)` do?**
It calls the parent class's constructor that takes a `String` parameter. This initializes the parent's `name` field. You must call it as the first line of the child constructor.

**Q: What is the difference between overriding and overloading?**
Overriding replaces a parent method with the same name AND same parameters. Overloading creates multiple methods with the same name but different parameters.

**Q: What is the difference between an abstract class and an interface?**
An abstract class can have fields, constructors, and finished methods (like `describe()`) alongside its abstract ones, and a class can extend only one. An interface is just a list of method headers, and a class can implement as many as it needs. `Square` uses both: it extends `Shape` and implements `Resizable`.

**Q: Why won't my code compile after I add `void scale(double factor);` to Resizable?**
Because `Square` implements `Resizable`, Java now requires `Square` to have a `scale(double factor)` method. Write it and the error goes away. The same goes for `area()` once you make it abstract in `Shape`.

**Q: For `Employee.getName()`, should I access the parent's `name` field directly?**
No — `name` is `private` in `Person`. Call `super.getName()` to get it: `return "Employee: " + super.getName();`

---

View all assignments and scoring breakdowns at [csplusplus.com/github-assignments](https://csplusplus.com/github-assignments)

*CS++ — AP Computer Science A — [csplusplus.com](https://csplusplus.com)*
