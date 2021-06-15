package com.github.thekeithsequeira.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    public  void merge(int[] elems, int low, int mid, int high){
        int i=low;
        int j=mid+1;
        int k=0;
        int[] tempElems =new int[elems.length];
        while(i<=mid && j<=high){
            if(elems[i]<=elems[j])
                tempElems[k++]=elems[i++];
            else
                tempElems[k++]=elems[j++];
        }

        while (i<=mid)
            tempElems[k++]=elems[i++];

        while (j<=high)
            tempElems[k++]=elems[j++];

        for (k = 0,i=low;  i<high ; i++,k++) {
            elems[i]=tempElems[k];
        }
    }

    public void mergeSort(int[] elems,int  low,int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(elems, 0, mid);
            mergeSort(elems, mid + 1, high);
            merge(elems, 0, mid, high);
        }
    }

    public static void main(String[] args) {
        int n;
        if (args[0]==null) {
            System.out.println("MergeSort Sort:\nEnter the number of elements:");
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
        } else {
            n = Integer.parseInt(args[0]);
        }
        Random random = new Random();
        int[] arr = random.ints(n, 0, 100).toArray();
        System.out.println("The generated elements are:" + Arrays.toString(arr));
        MergeSort mergeSortObj = new MergeSort();
        mergeSortObj.mergeSort(arr,0, arr.length);
        System.out.println("The sorted elements using Merge Sort are:" + Arrays.toString(arr));
    }

}
