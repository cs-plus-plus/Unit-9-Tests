# Unit 9: Inheritance

AP Computer Science A

## Overview

This project covers **Unit 9: Inheritance** concepts including `extends`, `super` keyword (in constructors and method calls), method overriding, accessing parent/child instance data, and static methods/variables. Complete the classes in `Unit9.java` and run the provided JUnit tests to verify your work.

## Getting Started

### Option 1: GitHub Codespaces (Recommended)

1. Click the green **Code** button on this repository
2. Select the **Codespaces** tab
3. Click **Create codespace on main**
4. Wait for the environment to build (~2 minutes the first time)
5. Start coding in `src/main/java/com/csplusplus/Unit9.java`

> **Note:** If the Java extension shows errors on first load, press `Cmd+Shift+P` (Mac) or `Ctrl+Shift+P` (Windows) and run **"Developer: Reload Window"**. This is a one-time setup step.

### Option 2: Local Development

1. Accept the assignment via the GitHub Classroom link
2. Clone the repository using GitHub Desktop
3. Open the project in your IDE
4. **Requirements:** Java 17+, Maven 3.x

## Running Tests

Run all tests:
```
mvn test
```

Run a single test:
```
mvn -Dtest=Unit9Test#testSuperConstructorAndMethod test
```

## Scoring

| # | Test | Points | Concepts |
|---|------|--------|----------|
| 1 | Super constructor & method override | 25 | `super()`, overriding `getName()` |
| 2 | Method overriding & parent method call | 25 | `@Override`, `super.makeSound()` |
| 3 | Child and parent instance data | 25 | Accessing inherited fields |
| 4 | Static method & variable | 25 | `static` keyword |
| | **Total** | **100** | |

## What You Need to Implement

### Pair 1: Person → Employee
- `Person`: constructor(String name), getName()
- `Employee extends Person`: constructor calls super(name), overrides getName(), getJobTitle()

### Pair 2: Animal → Dog
- `Animal`: constructor(String name), makeSound() returns "Some sound"
- `Dog extends Animal`: overrides makeSound() to return "Bark", makeParentSound() calls super.makeSound()

### Pair 3: Vehicle → Car
- `Vehicle`: constructor(int speed), getSpeed()
- `Car extends Vehicle`: constructor calls super(speed), getDetails() returns "Model: X, Speed: Y"

### Calculator (static)
- `public static int counter`
- `static add(int a, int b)`: increments counter, returns sum

## Common Mistakes

- Forgetting `super()` as the **first line** of the child constructor
- Not using `super.methodName()` to call parent's version of an overridden method
- Making `counter` an instance variable instead of `static`
- Forgetting that `protected` fields are accessible in child classes

## Autograding

Your code is automatically graded when you push to GitHub. Check the **Actions** tab to see your score.

## Contact

For questions, contact [kevin@csplusplus.com](mailto:kevin@csplusplus.com)
