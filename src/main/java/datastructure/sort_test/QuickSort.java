package datastructure.sort_test;

/**
 * @author aidar
 * @desc
 * @date 18-5-2
 */
public class QuickSort {
    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            int key = arr[mid];
            sort(arr, left, mid -1);
            sort(arr, mid + 1, right);

        }
    }

    public void quickSort(int[] arr, int key) {

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
        QuickSort instance = new QuickSort();
        instance.sort(arr, 0, arr.length - 1);
        instance.display(arr);
    }
}
