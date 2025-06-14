# Overview

This project provides a simple, extensible calculator implementation in Java that supports multiple operations. The calculator is designed to be easy to use, flexible, and extensible.

## Using the Calculator

To use the calculator, create an instance of the Calculator class and call the calculate method, passing in the operation and two numbers as arguments. For example:

```
Calculator calculator = new Calculator();
try {
    double result = calculator.calculate("ADD", 2, 3);
    System.out.println("Result: " + result);
} catch (UnsupportedOperation e) {
    System.out.println("Error: " + e.getMessage());
}
```

### Supported Operations

The calculator currently supports the following operations:
- ADD
- SUBTRACT
- MULTIPLY
- DIVIDE

### Chaining Operations

You can chain multiple operations together using the Chain class. For example:

```
Calculator calculator = new Calculator();
Calculator.Chain chain = calculator.chain(5);
double result = chain.apply(Operation.ADD, 3).apply(Operation.MULTIPLY, 2).getResult();
System.out.println("Result: " + result);
```

### Exception Handling

The calculator throws an UnsupportedOperation exception when an invalid operation is requested. You can catch this exception and handle it accordingly. For example:

```
try {
    calculator.calculate("POWER", 2, 3);
} catch (UnsupportedOperation e) {
    System.out.println("Error: " + e.getMessage());
}
```

### Extensibility

To add new operations to the calculator, simply add a new value to the Operation enum. For example:


enum Operation {
// existing operations...
POWER((a, b) -> Math.pow(a, b));

    // existing code...
}


The calculator will automatically support the new operation without any changes.#   p r o j e c t 1 
 
 #   p r o j e c t 
 
 
