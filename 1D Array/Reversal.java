//time complexity: O(n)
//space complexity: O(1) => no extra space used

public class Reversal {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int size = arr.length;
        for(int i = 0; i < size/2; i++){
            int temp = arr[i];
            arr[i] = arr[size-i-1];
            arr[size-i-1] = temp;
        }
        for(int i : arr)
        {System.out.print(i + " ");}
    }
}
