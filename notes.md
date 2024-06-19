
>>> Sliding Window
>>> 06/07/2023 14:00:00
https://leetcode.com/discuss/study-guide/3722472/mastering-sliding-window-technique-a-comprehensive-guide

https://leetcode.com/problems/frequency-of-the-most-frequent-element/solutions/1175088/C++-Maximum-Sliding-Window-Cheatsheet-Template!/


OOPS

    Object-Oriented Programming (OOP) is a programming paradigm that is centered around the concept 
    of objects. Objects are instances of classes, and classes define the blueprint for creating objects.
    OOP encourages the organization of code into reusable and self-contained units, making it easier to 
    manage and maintain complex software systems.


There are four main principles of OOP: 

                                encapsulation, 
                                inheritance, 
                                abstraction,
                                polymorphism.

Encapsulation: 

    Encapsulation helps in hiding the implementation details from the user and only
    provides the user with the information that is necessary.


Eg:
`java

    public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

java
`


Inheritance:

     Inheritance is a mechanism that allows you to eliminate redundant code by 
     creating a new class that inherits properties and behaviors from an existing class.
     It promotes code reusability and establishes a parent-child relationship between classes.


Abstraction:

    Abstraction is the process of hiding the internal details and showing only the functionality 
    to the users. It helps in reducing programming complexity and efforts. 
    It is achieved using abstract classes and interfaces.





Properties of Unit Tests:

    1. Isolated: Each unit test should be independent of other unit tests and should not rely on the
    2. Repeatable: A unit test should produce the same result every time it is run.
    3. Fast: Unit tests should be fast to execute so that they can be run frequently.
