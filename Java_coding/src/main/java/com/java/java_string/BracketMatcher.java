package com.java.java_string;

import java.util.Stack;

public class BracketMatcher {

    public static boolean isBalanced(String input) {
        if (input == null) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char opening = stack.pop();

                if ((ch == ')' && opening != '(')
                        || (ch == ']' && opening != '[')
                        || (ch == '}' && opening != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{([])}")); // true
        System.out.println(isBalanced("{([)}"));  // false
    }
}
