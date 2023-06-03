package com.zylear.problems.sort;

import java.util.Arrays;

/**
 * Created by xiezongyu on 2020/2/11.
 */
public class QuickSort {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1231, 234, 4, 86, 21, 6, 1, 4, 68, 34, 3, 3, 4, 7, 2, 2, 3, 4};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.asList(array));
    }

    public static void quickSort(Integer[] array,int left, int right){

        if (left >= right) {
            return;
        }

        int start = left;
        int end = right;
        while (left < right) {

            while (left < right && array[right] >= array[left]) {
                right--;
            }
            swap(array, left, right);

            while (left < right && array[right] >= array[left]) {
                left++;
            }
            swap(array, left, right);
        }

        quickSort(array, start, left - 1);
        quickSort(array, left + 1, end);


    }






    public static void quickSort1(Integer[] array, int low, int high) {
        int lowIndex, highIndex, temp;
        if (low >= high) {
            return;
        }
        lowIndex = low;
        highIndex = high;
        //temp就是基准位
        temp = array[low];

        while (lowIndex < highIndex) {

            while (lowIndex < highIndex) {
                if (temp > array[highIndex]) {
                    swap(array, lowIndex, highIndex);
                    break;
                } else {
                    highIndex--;
                }
            }

            while (lowIndex < highIndex) {
                if (temp < array[lowIndex]) {
                    swap(array, lowIndex, highIndex);
                    break;
                } else {
                    lowIndex++;
                }
            }


        }

        //递归调用左半数组
        quickSort(array, low, highIndex - 1);
        //递归调用右半数组
        quickSort(array, highIndex + 1, high);
    }

    private static void swap(Integer[] array, int lowIndex, int highIndex) {

        int temp = array[lowIndex];
        array[lowIndex] = array[highIndex];
        array[highIndex] = temp;

    }


}
