package sort;

public class QuickSort3Way {
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

        int left = start;
        int value = array[start];
        int right = end;
        int i = left + 1;
        while (i <= right){
            int cmp = array[i] - value;
            if(cmp == 0){
                i++;
            }else if(cmp < 0){
                swap(array, i, left);
                left++;
                i++;
            }else{
                swap(array, i, right);
                right--;
            }
        }
        sort(array, start, left - 1);
        sort(array, right + 1, end);
    }

    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSort3Way quickSort3Way = new QuickSort3Way();
        int[] array = new int[]{3,76,1,2,-1,3,142,14,32,3,45,3,5,23,67};
        quickSort3Way.sort(array);
        for (int item : array){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
