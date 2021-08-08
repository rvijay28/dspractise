package org.example;

import java.util.Stack;

public class SortedStack {

    public static Stack<Integer> sort(Stack<Integer> original) {

        if (original == null || original.isEmpty()) {
            return null;
        }
        Stack<Integer> sortedStack = new Stack<>();
        while (!original.isEmpty()) {
            int temp = original.pop();
            if (!sortedStack.isEmpty()) {
                while (!sortedStack.isEmpty() && temp < sortedStack.peek()) {
                    original.push(sortedStack.pop());
                }
            }
            sortedStack.push(temp);
        }
        return sortedStack;
    }
}
