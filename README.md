# CS++ Java — Unit 9: Inheritance

> **Unit 9** | 100 Points | 4 Autograded Tests

In this assignment you will use `extends`, the `super` keyword, method overriding with `@Override`, and work with parent/child class hierarchies. You will also implement a static method with a class-level counter.

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

### Static Methods and Variables

Static members belong to the class, not to any individual object:

```java
public class Calculator {
    public static int counter = 0;

    public static int add(int a, int b) {
        counter++;
        return a + b;
    }
}

// Usage:
Calculator.add(3, 5);     // returns 8, counter is 1
Calculator.add(10, 20);   // returns 30, counter is 2
System.out.println(Calculator.counter);  // 2
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

### Group 4: Calculator (25 pts)

A standalone class (no inheritance) with static members:
- Static variable: `public static int counter` (starts at 0)
- Static method: `add(int a, int b)` — increments `counter` and returns `a + b`

```java
Calculator.counter             // 0
Calculator.add(3, 5)           // returns 8, counter is 1
Calculator.add(10, 20)         // returns 30, counter is 2
Calculator.counter             // 2
```

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
    public static class Calculator { ... }
}
```

---

## Autograding

| Test | What It Checks | Points |
|------|---------------|--------|
| testPersonEmployee | super constructor, getName override, getJobTitle | 25 |
| testAnimalDog | makeSound override, makeParentSound calls super | 25 |
| testVehicleCar | Inherited getSpeed, getDetails format | 25 |
| testCalculator | Static counter increments, add returns correct sum | 25 |

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

**Example 3 — Static counter:**
```java
// Practice.java
public class Practice {
    static class Counter {
        public static int count = 0;
        public static int increment() {
            count++;
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(Counter.increment());  // 1
        System.out.println(Counter.increment());  // 2
        System.out.println(Counter.increment());  // 3
        System.out.println("Total: " + Counter.count);  // 3
    }
}
```

---

## Tips for Success

1. `super(args)` must be the **first line** in a child constructor
2. Use `@Override` annotation when overriding a method — it helps catch typos
3. Use `super.methodName()` to call the parent's version of an overridden method
4. All classes in this assignment are `static inner classes` of `Unit9`
5. The `Calculator.counter` must be `public static` so the test can access it directly
6. The `getDetails()` format must match exactly: `"Model: [model], Speed: [speed]"`

---

## FAQ

**Q: Why are these inner classes instead of separate files?**
The autograder expects all classes inside `Unit9.java`. Using `public static` inner classes lets you define multiple classes in one file.

**Q: What does `super(name)` do?**
It calls the parent class's constructor that takes a `String` parameter. This initializes the parent's `name` field. You must call it as the first line of the child constructor.

**Q: What is the difference between overriding and overloading?**
Overriding replaces a parent method with the same name AND same parameters. Overloading creates multiple methods with the same name but different parameters.

**Q: For `Employee.getName()`, should I access the parent's `name` field directly?**
No — `name` is `private` in `Person`. Call `super.getName()` to get it: `return "Employee: " + super.getName();`

---

View all assignments and scoring breakdowns at [csplusplus.com/maven-tests](https://csplusplus.com/maven-tests)

*CS++ — AP Computer Science A — [csplusplus.com](https://csplusplus.com)*
