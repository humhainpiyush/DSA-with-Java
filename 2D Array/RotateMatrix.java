//Time compelxity: O(m*n)
//Space complexity: O(1)

import java.util.Arrays;

public class RotateMatrix {

    public static void rotateMatrix(int [][] arr){
    //Step 1: Find the transpose
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    //Step 2: Swap the columns -> Col(first) <--> Col(last)
        swap(arr);
    }

    public static void swap(int [][] arr){
        int cols = arr[0].length;

        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j <cols/2; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][cols-1-j];
                arr[i][cols-1-j] = temp;
            }
        }
    }

    public static void dispArray(int [][] arr){
        for(var a : arr){
            System.out.println(Arrays.toString(a));
        }
    }
    public static void main(String[] args) {
        // int[][] arr = {
        //     {1,2,3,4},
        //     {5,6,7,8},
        //     {9,10,11,12},
        //     {13,14,15,16}
        // };
        int[][] arr = {
            {1,2,3},
            {4,5,6}
        };
        dispArray(arr);
        System.out.println();
        rotateMatrix(arr);
        // swap(arr);
        dispArray(arr);
    }
}
