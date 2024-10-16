
# Unit 9 - Inheritance and JUnit Tests

This project is designed to help you understand the key concepts of inheritance in Java, such as:
- Using `super` in constructors and methods
- Overriding methods and calling parent methods
- Using instance data from both parent and child classes
- Understanding and working with static methods and variables

## Project Structure

- **Unit9.java**: This file contains several classes that you need to complete by following the provided comments. You will be working with inheritance, method overriding, `super` keyword usage, and static methods.
- **Unit9Test.java**: This file contains JUnit tests to check your understanding of the key concepts. Once you've completed the tasks in `Unit9.java`, the tests will help you verify that your implementations are correct.

## Getting Started

### Prerequisites

Make sure you have the following tools installed:
- **Java** (JDK 8 or later)
- **Maven** (for managing dependencies and running tests)


### Instructions

1. Open `Unit9.java` located in the `src/main/java/com/csplusplus` directory.
2. Follow the comments in each class to implement the required constructors, methods, and any other code.
3. Once you've completed the implementation, run the JUnit tests to check your work.


### Test Coverage

The tests in `Unit9Test.java` cover the following topics:

1. **Super in Constructors and Methods**:
   - Ensure that the child class calls the parent constructor using `super`.
   - Test method overriding and using `super` to call the parent method.

2. **Method Overriding and Parent Method Calls**:
   - Verify that child classes properly override methods.
   - Ensure that the child class can still access parent methods when necessary.

3. **Using Parent and Child Instance Data**:
   - Make sure child classes can use both their own instance data and data inherited from the parent class.

4. **Static Methods and Variables**:
   - Check that static methods work correctly and that static variables retain their value across method calls.

### Key Concepts

- **Inheritance (`extends`)**: Allows one class (child class) to inherit fields and methods from another class (parent class).
- **Polymorphism**: Allows objects of different types to be treated as objects of a common parent type.
- **Method Overriding**: Allows a subclass to provide a specific implementation of a method that is already defined in its parent class.
- **The `super` Keyword**: Refers to the parent class and is used to invoke the parent class's constructor and methods.
- **Static Methods and Variables**: Methods that belong to the class rather than any instance of the class, and variables that are shared among all instances.


## Additional Resources

- [Oracle Java Documentation - Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- [Oracle Java Documentation - Polymorphism](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)
- [JUnit Documentation](https://junit.org/junit5/docs/current/user-guide/)

---

## Support
If you encounter any issues or have questions about the assignment, please reach out during office hours or post in the course discussion forum.

For additional assistance, contact: **Kevin** at [kevin@csplusplus.com](mailto:kevin@csplusplus.com).



