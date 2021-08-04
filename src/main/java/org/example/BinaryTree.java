package org.example;

import java.util.*;

public class BinaryTree {

    Node root;
    int maxLevel = -1;

    private Node addRecursively(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursively(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursively(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    private void addNodeWithoutRecursion(int value) {

        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }

        Node temp = null;
        Node current = root;

        while (current != null) {
            temp = current;
            if (current.value > value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (temp == null) {
            temp = newNode;
        }
        if (temp.value > value) {
            temp.left = newNode;
        } else {
            temp.right = newNode;
        }

    }

    public void add(int value) {
        root = addRecursively(root, value);
    }

    public void insert(int value) {
        addNodeWithoutRecursion(value);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }
    public void inOrderWithoutRecursion(Node root) {
        if (root == null){
            return;
        }
        System.out.println("\n=================");
        Node current = root;
        Stack<Node> stack = new Stack<>();
        stack.push(current);
        while(!stack.isEmpty()) {

            while (current != null) {
                current = current.left;

                if (current != null) {
                    stack.push(current);
                }
            }
            if (current == null) {
                current = stack.pop();
                System.out.print(current.value + " ");
                current = current.right;
                if (current != null) stack.push(current);
            }

        }
    }
    public String serialize(Node node) {
        if (node == null) return "#";
        String leftSerialized = serialize(node.left);
        String rightSerialized = serialize(node.right);
        return node.value + "," + leftSerialized + "," + rightSerialized;
    }

    public Node deserialize(String serialized) {
        String[] valuesArr = serialized.split(",");
        Queue<String> values = new LinkedList<>(Arrays.asList(valuesArr));
        return deserializationHelper(values);

    }
    public void leftViewOfTree(Node root) {

        leftViewOfTreeHelper(root, 0);
    }
    private void leftViewOfTreeHelper(Node node, int level){
        if (node == null) return;

        if (this.maxLevel < level) { //not visited
            System.out.print(node.value + " ");
            this.maxLevel = level; //mark level visited
        }
        leftViewOfTreeHelper(node.left, level +1);
        leftViewOfTreeHelper(node.right, level + 1);
    }
    private Node deserializationHelper(Queue<String> values) {
        String value = values.poll();
        if (value == null || value.equals("#")) return null;
        Node newNode = new Node(Integer.parseInt(value));
        newNode.left = deserializationHelper(values);
        newNode.right = deserializationHelper(values);
        return newNode;

    }
    public void topView(Node root) {
        Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();
        topViewHelper(root, 0, 0, map );
        for(Pair result: map.values()) {
            System.out.print(result.first + " ");
        }
    }
    
    public void topViewHelper(Node node, int level, int dist, Map<Integer, Pair<Integer, Integer>> map) {
        if (node == null)return;

        if (!map.containsKey(dist) || level < map.get(dist).second ) {
            map.put(dist, new Pair<Integer, Integer>(node.value, level));
        }
        topViewHelper(node.left, level + 1, dist - 1, map);
        topViewHelper(node.right, level + 1, dist + 1, map );

    }

    class Pair<U, V>
    {
        public final U first;       // first field of a pair
        public final V second;      // second field of a pair

        // Constructs a new Pair with specified values
        public Pair(U first, V second)
        {
            this.first = first;
            this.second = second;
        }

    }
}
