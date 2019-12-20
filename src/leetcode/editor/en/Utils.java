package leetcode.editor.en;

import java.util.List;

public class Utils {
    public static void printIntArray(int[] array){
        if(array == null){
            throw new RuntimeException("oh, empty array found");
        }
        System.out.print("[ ");
        for (int item : array){
            System.out.print(item + " ");
        }
        System.out.println("]");
    }
    public static void printStringList(List<String> list){
        for (String str : list){
            System.out.print("[");
            System.out.print(str);
            System.out.print("]");
            System.out.println();
        }
    }
}
