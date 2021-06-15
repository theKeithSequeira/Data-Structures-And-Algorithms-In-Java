package com.github.thekeithsequeira.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void quickSort(int[] a, int lb, int ub) {
        if (lb < ub) {
            int j = partition(a, lb, ub);
            quickSort(a, lb, j - 1);
            quickSort(a, j + 1, ub);
        }
    }

    public static int partition(int[] a, int lb, int ub) {
        int up = ub;
        int dn = lb + 1;
        int pivot = a[lb];
        do {
            while (a[dn] < pivot && dn <= ub)
                dn++;
            while (a[up] > pivot && up > lb)
                up--;
            if (dn < up) {
                int temp = a[dn];
                a[dn] = a[up];
                a[up] = temp;
            }
        } while (dn < up);
        a[lb] = a[up];
        a[up] = pivot;
        return up;
    }

    public static void main(String[] args) {
        int n;
        if (args[0] == null) {
            System.out.println("Quick Sort:\nEnter the number of elements:");
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
        } else {
            n = Integer.parseInt(args[0]);
        }
        Random random = new Random();
        int[] arr = random.ints(n, 0, 100).toArray();
        System.out.println("The generated elements are:" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("The sorted elements using Quick Sort are:" + Arrays.toString(arr));
    }
}
