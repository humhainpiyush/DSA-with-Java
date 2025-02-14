//time complexity: O(n)
//space complexity: O(1)

public class Missing {
    static int missingNumber(int a[], int n)//this method is another approach for the same problem
    {//here the integer overflow is minimized by taking the sum and subtracting the elements of the array during each iteration
        int total = 1;
        for (int i = 2; i <= (n + 1); i++) {
            total += i;
            total -= a[i - 2];
        }
        return total;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int size = arr.length;

        int sumNatural = (size + 1)*(size + 2)/2;
        int sum = 0;
        for(int i = 0; i<size; i++){
            sum += arr[i];
        }

        System.out.println("The missing number is: " + (sumNatural - sum));

        // System.out.println(missingNumber(arr, size));
    }
}
