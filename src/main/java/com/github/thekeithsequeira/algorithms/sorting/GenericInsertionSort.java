package com.github.thekeithsequeira.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GenericInsertionSort {
    public <T extends Comparable<T>> void sort(T[] elem) {
        int size = elem.length;
        for (int j = 1; j < size; j++) {
            for (int i = j; i > 0; i--) {
                if (elem[i - 1].compareTo(elem[i]) > 0) {
                    T temp = elem[i];
                    elem[i] = elem[i - 1];
                    elem[i - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n;
        if (args[0] != null)
            n = Integer.parseInt(args[0]);
        else {
            System.out.println("Insertion Sort:\nEnter the number of elements:");
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
        }
        Random random = new Random();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("The generated elements are:" + Arrays.toString(arr));
        GenericInsertionSort genericInsertionSort = new GenericInsertionSort();
        genericInsertionSort.sort(arr);
        System.out.println("The sorted elements using Insertion Sort are:" + Arrays.toString(arr));
    }
}
