package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        BinaryTree bTree = new BinaryTree();
        bTree.insert(6);
        bTree.insert(4);
        bTree.insert(8);
        bTree.insert(3);
        bTree.insert(5);
        bTree.insert(9);
        bTree.insert(7);
        bTree.inOrder(bTree.root);
        bTree.inOrderWithoutRecursion(bTree.root);
        String serializedTree = bTree.serialize(bTree.root);
        System.out.println();
        System.out.println(serializedTree);
        Node deserializedTree = bTree.deserialize(serializedTree);
        System.out.println("*******************");
        bTree.inOrder(deserializedTree);
        System.out.println("*******************");
        bTree.leftViewOfTree(bTree.root);
        System.out.println("*******************");
        bTree = new BinaryTree();
        bTree.insert(15);
        bTree.insert(5);
        bTree.insert(6);
        bTree.insert(7);
        bTree.insert(8);
        bTree.insert(25);
        bTree.topView(bTree.root);

        System.out.println();
        System.out.println("Testing TwoStack");
        TwoStack twoStack = new TwoStack(3);
        twoStack.push1(10);
        twoStack.push2(90);
        twoStack.push2(85);
        twoStack.visit();
        twoStack.pop2();
        twoStack.pop2();
        twoStack.pop2();
        twoStack.visit();
        twoStack.push1(24);
        twoStack.push1(55);
        twoStack.visit();

        int[] arr = {18,19,20,20,20,22,23,23,24};
        BinarySearch bs = new BinarySearch();
        boolean found = bs.search(22, arr);
        int totalOccurrence = 0;
        if (found) {
            int first = bs.findFirstOccurrence(22, arr);
            int last = bs.findLastOccurrence(22, arr);
            System.out.println("First occurrence index = " + first);
            System.out.println("Last occurrence index = " + last);
            totalOccurrence = (last - first) + 1;
        } else {

        }
        System.out.println("Total occurrence = " + totalOccurrence);

    }
}
