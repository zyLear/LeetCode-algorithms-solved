package com.zylear.problems.sort;

import java.util.Arrays;

/**
 * Created by xiezongyu on 2020/2/11.
 */
public class MergeSort {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1231, 234, 4, 86, 21, 6, 1, 4, 68, 34, 3, 3, 4, 7, 2, 2, 3, 4};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.asList(array));
    }

    public static void mergeSort(Integer[] array, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        mergeSortArray(array, left, mid, mid + 1, right);

    }

    private static void mergeSortArray(Integer[] array, int left1, int right1, int left2, int right2) {
        Integer[] temp = Arrays.copyOfRange(array, left1, right2 + 1);

        int index = left1;

        int i = 0;
        int j = left2 - left1;
        int end1 = right1 - left1;
        int end2 = right2 - left1;
        while (i <= end1 || j <= end2) {
            if (i > end1) {
                array[index] = temp[j];
                j++;
                index++;
                continue;
            }
            if (j > end2) {
                array[index] = temp[i];
                i++;
                index++;
                continue;
            }

            if (temp[i] > temp[j]) {
                array[index] = temp[j];
                j++;
                index++;
            } else {
                array[index] = temp[i];
                i++;
                index++;
            }
        }


    }


    private static void swap(Integer[] array, int lowIndex, int highIndex) {

        int temp = array[lowIndex];
        array[lowIndex] = array[highIndex];
        array[highIndex] = temp;

    }


}
