package com.brzyang.java8;

public class MergeSortedArray {
    public static void main(String[] args) {
        for (int i : mergeSortedArray(new int[]{}, new int[]{1, 2, 3})) {
            System.out.print(i + " ");
        }

        System.out.println("");

        for (int i : mergeSortedArray(new int[]{1, 2, 3}, new int[]{})) {
            System.out.print(i + " ");
        } System.out.println("");

        for (int i : mergeSortedArray(new int[]{1, 2, 3}, new int[]{1, 2, 3})) {
            System.out.print(i + " ");
        } System.out.println("");

        for (int i : mergeSortedArray(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4})) {
            System.out.print(i + " ");
        } System.out.println("");
        for (int i : mergeSortedArray(new int[]{3, 4}, new int[]{1, 2, 3, 4, 5})) {
            System.out.print(i + " ");
        } System.out.println("");

        for (int i : mergeSortedArray(new int[]{3, 4}, new int[]{1, 2, 3, 4})) {
            System.out.print(i + " ");
        } System.out.println("");

        for (int i : mergeSortedArray(new int[]{1, 2, 3, 4}, new int[]{1, 2})) {
            System.out.print(i + " ");
        } System.out.println("");
    }

    private static int[] mergeSortedArray(int[] a, int[] b) {
        if (a.length + b.length > Integer.MAX_VALUE) {
            throw new RuntimeException(" exceed max int");
        }
        int[] merged = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length){
            if (a[i] > b[j]){
                merged[k] = b[j];
                j++;
            }else{
                merged[k] = a[i];
                i++;
            }
            k++;
        }

        while (i < a.length){
            merged[k++] = a[i++];
        }

        while (j < b.length){
            merged[k++] = b[j++];
        }

        return merged;
    }
}
