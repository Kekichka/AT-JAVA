package task3;
import java.util.*;

//V4.
//Array Intersection: Write a Java program that takes two arrays of integers and finds their intersection. Your program should prompt the user to enter the size and the elements of both arrays and then output the common elements between them.
//Make HashMap from the result array and perform the following operations: a) Add a key-value pair to the map; b) Remove a key-value pair from the map; c) Check if a key is in the map; d) Find the value associated with a given key; e) Print all the keys and values in the map;
//Make up the situation for NumberFormatException. Catch it and display the explanation for your custom case.

public class ArrayIntersection {
    public static void main(String[] args) {

        int[] arr1 = {3, 5, 77, 8, 0, 1};
        int[] arr2 = {0, 3, 6, 77, 4, 5};

        ArrayList<Integer> inter = new ArrayList<>();
        for (int x : arr1) {
            for (int y : arr2) {
                if (x == y && !inter.contains(x)) {
                    inter.add(x);
                }
            }
        }

        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        System.out.println("Intersection: " + inter);

        HashMap<Integer, String> map = new HashMap<>();
        for (int num : inter) {
            map.put(num, "Value_" + num);
        }

        map.put(777, "Extra");
        System.out.println("After add: " + map);

        map.remove(777);
        System.out.println("After remove: " + map);

        if (!inter.isEmpty() && map.containsKey(inter.get(0))) {
            System.out.println("Map contains key " + inter.get(0));
        }

        for (Integer k : map.keySet()) {
            System.out.println("Value for " + k + ": " + map.get(k));
        }

        System.out.println("All map:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        try {
            int num = Integer.parseInt("m");
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("oops! m is not a number");
        }

    }
}
