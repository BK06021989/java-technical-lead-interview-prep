package com.java.oops;

/*If we cannot create an object of an abstract class, 
what is the purpose of having a constructor in an abstract class?
Initialization for subclasses
Code reuse
*/
abstract class Animal {
    String name="Bipin";
    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called: "+name);
    }
}
class Dog extends Animal {
    Dog(String name) {
        super(name); // calls abstract class constructor
        System.out.println("Dog constructor called: "+name);
    }
}
public class AbstractConstructor {
    public static void main(String[] args) {
        Dog d = new Dog("Bruno");
    }
}
//Output: Animal constructor called: Bruno
//		  Dog constructor called: Bruno
