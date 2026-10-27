package com.java.oops;

public class MainGreeting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Using implements
        Greeting first = new FriendlyGreeting();
        first.sayHello();

        // 2. Anonymous class
        Greeting second = new Greeting() {
            public void sayHello() {
                System.out.println("Hello from an anonymous class!");
            }
        };
        second.sayHello();

        // 3. Lambda
        Greeting third = () -> System.out.println("Hello from a lambda!");
        third.sayHello();
	}

}
