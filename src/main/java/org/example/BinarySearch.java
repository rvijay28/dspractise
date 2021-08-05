package org.example;

public class BinarySearch {

    public boolean search(int value, int arr[]) {
        System.out.println();
        if (arr == null || !(arr.length > 0)) {
            System.out.println("Empty array!");
            return  false;
        }
        int index = search(value, 0, arr.length - 1, arr);
        if (index != -1) {
            System.out.println("Found value {" + value + "} in the array at index {"
            + (index + 1) + "}");
            return true;
        } else {
            System.out.println("Did not find value {" + value + "} in the array");
            return false;
        }
    }
    private int search(int value, int min, int max, int arr[]) {
        if (max >= 1 ) {

            int mid = min + (max - min) / 2;
            System.out.println("mid = " + mid + ", value at mid " + arr[mid]);
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                return search(value, mid + 1, max, arr);
            } else {
                return search(value, min, mid - 1, arr);
            }
        } else {
            return -1;
        }
    }
    public int findFirstOccurrence(int value, int[] arr) {
        int index = search(value, 0, arr.length - 1 , arr);
        int first = index;
        if (index != -1) {
            for(int i = 0; i < index -1 ; i++) {
                if (arr[i] == value) {
                    first = i;
                    break;
                }
            }

        }
        return first;
    }

    public int findLastOccurrence(int value, int[] arr) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int index = search(value, 0, arr.length - 1, arr);
        int last = index;
        if (index != -1) {
           for(int i = index +1; i < arr.length -1; i++) {
               if (arr[i] == value){
                   last = i;
               }
           }
        }
        return last;
    }
}
