package datastructure.sort_test;

/**
 * @author aidar
 * @desc
 * @date 18-5-2
 */
public class MergeSort {
    public void sort(int[] arr, int left, int right) {
        if (left < right ) {
            int mid = (left + right) >> 1;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int[] tmp =new int[arr.length];
        int i=left;
        int mmid = mid + 1;
        int j = left;
        while (left <= mid && right >= mmid) {
            if ( arr[left] > arr[mmid])
                tmp[i++] = arr[mmid++];
            else
                tmp[i++] = arr[left++];
        }
        while (left <= mid)
            tmp[i++] = arr[left++];
        while (mmid <= right)
            tmp[i++] = arr[mmid++];

        while (j <= right)
            arr[j] = tmp[j++];
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
        MergeSort instance = new MergeSort();
        instance.sort(arr, 0, arr.length - 1);
        instance.display(arr);
    }
}
