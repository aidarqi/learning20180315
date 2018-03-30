package datastructure.sort_test;

import java.io.Serializable;

/**
 * @author aidar
 * @desc
 * @date 18-3-29
 */
public class SelectSort {

    public void sort(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            tmp = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[tmp])
                    tmp = j;
            }
            swap(arr, i, tmp);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void display(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,7,9,4,0,3};
        SelectSort instance = new SelectSort();
        instance.sort(arr);
        instance.display(arr);
    }
}
