package org.example;

public class TwoStack {

    private static final int DEFAULT_SIZE = 10;
    private int stack1Size;
    private int stack2Size;

    private int stack1CurrentIndex = -1;
    private int stack2CurrentIndex = -1;
    private int[] intArray;

    public TwoStack() {
        this(DEFAULT_SIZE);
    }

    public TwoStack(int size) {
        if (size > 0) {
            intArray = new int[size];
            this.stack1CurrentIndex = 0;
            this.stack2CurrentIndex = intArray.length - 1;
        }else {
            System.out.println("size cannot be less than 1");
            throw new RuntimeException("Invalid size");
        }
    }

    void push1(int value){
        //add first stack from top
        /* example: array of 5 elements
            stack1 elements at index 0,1
            stack 2 elements at index 4,3
            free index is 2
            so check stack1 has free element in array to add
            stack1index + 1 < stack2index, yes add
            if 4,3,2 is taken by stack2 stack2 current index is
         */
        int nextIndex = -1;
        if (stack1Size < 1) {
            nextIndex = stack1CurrentIndex;
        } else {
            nextIndex = stack1CurrentIndex + 1;
        }

        if ((nextIndex < stack2CurrentIndex )) {
            //increment stack size
            stack1Size++;
            intArray[nextIndex] = value;
            stack1CurrentIndex = nextIndex;
        } else {
            System.out.println("Stack1 is full!");
        }

    }
    void push2(int value) {
        //add second stack from bottom
        int nextIndex = -1;
        if (stack2Size < 1) {
            nextIndex = stack2CurrentIndex;
        } else {
            nextIndex = stack2CurrentIndex - 1;
        }
        if ((stack2CurrentIndex > stack1CurrentIndex )) {
            //increment stack size
            stack2Size++;
            intArray[nextIndex] = value;
            stack2CurrentIndex = nextIndex;
        } else {
            System.out.println("Stack2 is full!");
        }

    }
    int pop1(){
        if (stack1Size < 0) {
            //no elements
        }
        stack1Size--;
        int value = intArray[stack1CurrentIndex];
        intArray[stack1CurrentIndex] = -1;
        stack1CurrentIndex = stack1CurrentIndex - 1;
        if (stack1CurrentIndex < 0) {
            stack1CurrentIndex = 0;
        }
        return value;
    }

    int pop2(){
        if (stack2Size < 0) {
            //no elements
        }
        stack2Size--;
        int value =  intArray[stack2CurrentIndex];
        intArray[stack2CurrentIndex] = -1;
        stack2CurrentIndex = stack2CurrentIndex + 1;
        if (stack2CurrentIndex > (intArray.length - 1)){
            stack2CurrentIndex = intArray.length -1;
        }
        return value;
    }

    public void visit() {
        System.out.println();
        for(int value: intArray) {
            System.out.print(value + " ");
        }
    }
}
