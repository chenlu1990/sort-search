package com.example.demo;

/**
 * Created by chenlu on 2017/12/1.
 */
public class SearchDemo {
    public static int binarySearch(int[] arr, int data) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (arr[middle] == data) {
                return middle;
            } else if (data < arr[middle]) {
                high = middle - 1;
            } else if (data > arr[middle]) {
                low = middle + 1;
            }
        }
        return -1;

    }

    public static int search(int[] arr, int data, int begin, int end) {
        int middle = (begin + end) / 2;
        if (data < arr[begin] || data > arr[end]) {
            return -1;
        }
        if (data < arr[middle]) {
            return search(arr, data, begin, middle - 1);
        } else if (data > arr[middle]) {
            return search(arr, data, middle + 1, end);
        } else {
            return middle;
        }

    }

    public static void main(String[] args) {
        int[] arr = {6, 12, 33, 87, 90, 97, 108, 561};
        System.out.println(bSearch(arr, 108, 0, arr.length - 1));
        System.out.println("-----");
        System.out.println(binarySearch(arr, 561));
    }

    public static int bSearch(int[] arr, int data, int begin, int end) {
        int middle = (begin + end) / 2;
        if (data < arr[begin] || data > arr[end]) {
            return -1;
        }
        if (data == arr[middle]) {
            return middle;
        } else if (data < arr[middle]) {
            return bSearch(arr, data, begin, middle - 1);
        } else {
            return bSearch(arr, data, middle + 1, end);
        }
    }
}
