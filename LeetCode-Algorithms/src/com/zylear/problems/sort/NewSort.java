package com.zylear.problems.sort;

import java.util.Arrays;

public class NewSort {

    public static void main(String[] args) {

        Integer[] array = new Integer[]{1231, 234, 4, 86, 21, 6, 1, 4, 68, 34, 3, 3, 4, 7, 2, 2, 3, 4};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.asList(array));

    }

    private static void quickSort(Integer[] array, int left, int right) {

        int leftIndex, rightIndex, temp;
        if (left>=right){
            return;
        }

        leftIndex = left;
        rightIndex = right;

        temp = array[left];

        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex) {
                if (temp<=array[rightIndex]){
                    rightIndex--;
                }else {
                    swap(array, leftIndex, rightIndex);
                    break;
                }
            }
            while (leftIndex<rightIndex){
                if (temp >= array[leftIndex]) {
                    leftIndex++;
                }else {
                    swap(array, leftIndex, rightIndex);
                    break;
                }
            }
        }


    }

    private static void swap(Integer[] array, int leftIndex, int rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

}
