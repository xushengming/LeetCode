package sort;

public class QuickSort {
    private void sort(int[] array){
       if(array == null || array.length < 2){
           return;
       }
       sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end){
        if(start >= end){
            return;
        }
        int j = partition(array, start, end);
         sort(array, start, j - 1);
         sort(array, j + 1, end);
    }

    private int partition(int[] array, int start, int end){
        int pivot = array[start];
        int left = start;
        left++;
        int right = end;
        while (true){
            while (left < end && array[left] <= pivot){
                left++;
            }
            while (right >= start && array[right] > pivot){
                right--;
            }
            if(left >= right){
                break;
            }else{
                swap(array, left, right);
            }
        }
        swap(array, start, right);
        return right;
    }

    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = new int[]{3,76,1,2,-1,3,142,14,32,3,45,3,5,23,67};
        quickSort.sort(array);
        for (int item : array){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
