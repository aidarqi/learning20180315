package datastructure.sort_test;

/**
 * @author aidar
 * @desc
 * @date 18-3-29
 */
public class InsertSort {
    public void sort(int[] arr) {
        int tmp = 0;
        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > tmp){
                arr[j+1] = arr[j];
                arr[j] = tmp;
                j--;
            }
        }
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
        InsertSort instance = new InsertSort();
        instance.sort(arr);
        instance.display(arr);
    }
}
