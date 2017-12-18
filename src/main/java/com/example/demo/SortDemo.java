package com.example.demo;

/**
 * Created by chenlu on 2017/12/18.
 */

public class SortDemo {

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//控制排序趟数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {//比较大小选出最大值
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int k = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > k; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = k;
        }
    }

    //选择排序
    public static void selectedSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    int temp = arr[j];
                    arr[j] = min;
                    min = temp;
                }
            }
            arr[i] = min;
        }
    }

    public static int getMiddle(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    //快速排序
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = getMiddle(arr, low, high);
            quickSort(arr, low, middle - 1);
            quickSort(arr, middle + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 6, 3, 5, 8, 2, 7};
        System.out.print("原始数据：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        //bubbleSort(arr);
        //insertSort(arr);
        //selectedSort(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println();
        System.out.print("排序后的数据：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
