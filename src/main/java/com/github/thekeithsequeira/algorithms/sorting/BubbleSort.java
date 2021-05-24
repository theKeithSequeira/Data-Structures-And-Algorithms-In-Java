package com.github.thekeithsequeira.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    public void sort(int[] arr) {
        int compCount = 0, swapCount = 0;
        boolean swap;
        int n = arr.length;
        for (int pass = 1; pass < n; pass++) {
            swap = false;
            for (int i = 0; i < n - pass; i++) {
                compCount++;
                if (arr[i] > arr[i + 1]) {
                    swapCount++;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;
                }
            }
            if (!swap)
                break;
        }
        System.out.println("Total Comparison Count:" + compCount + " ,Total Swap Count:" + swapCount);
    }

    public static void main(String[] args) {
        System.out.println("BubbleSort:\nEnter the number of elements:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Random random = new Random();
        int[] arr = random.ints(n, 0, 100).toArray();
        System.out.println("The generated elements are:" + Arrays.toString(arr));
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        System.out.println("The sorted elements using Bubble Sort are:" + Arrays.toString(arr));
    }
}
