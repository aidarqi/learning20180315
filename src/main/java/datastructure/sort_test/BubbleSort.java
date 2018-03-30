package datastructure.sort_test;

/**
 * @author aidar
 * @desc
 * @date 18-3-29
 */
public class BubbleSort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
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
        BubbleSort instance = new BubbleSort();
        instance.sort(arr);
        instance.display(arr);
    }
}
