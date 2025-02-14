//time complexity: O(n)
//space complexity: O(1)

public class Palindrome {
    public static void main(String[] args) {
        int [] arr = {1,2,3,2,1,};
        int size = arr.length;
        int flag = 0;
        for(int i = 0 ; i< size/2; i++){
            if(arr[i] != arr[size - 1 -i]){
                flag = 1;
                System.out.println("Not Palindromic array");
                break;
            }
        }
        if(flag == 0){
            System.out.println("Palindromic Array");
        }
    }
}
