import java.util.Scanner;

public class PrefixSumApproach {
    public static void rowPrefixSum(int [][] arr){
        int m = arr.length;
        int n = arr[0].length;
        for(int i = 0; i<m; i++){
            for(int j = 1; j<n; j++){
                arr[i][j] += arr[i][j-1];
            }
        }
    }

    public static void colPrefixSum(int [][] arr){
        int m = arr.length;
        int n = arr[0].length;
        for(int j = 0; j<n; j++){
            for(int i = 1; i<m; i++){
                arr[i][j] += arr[i-1][j];
            }
        }
    }

    public static int sumRegion(int [][] arr, int r1, int c1, int r2, int c2){
        int sum = 0, up = 0, left = 0, repeatRegion = 0, result = 0;
        sum = arr[r2][c2];
        up = arr[r1-1][c2];
        left = arr[r2][c1-1];
        repeatRegion = arr[r1-1][c1-1];

        result = sum - up - left + repeatRegion;
        return result;
    }

    public static void dispArray(int [][] arr){
        System.out.println("Your desired Matrix is: ");
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();
        int [][] arr = new int[rows][columns];
        System.out.println("Enter elements:");
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int r1 = 0, c1 = 0, r2 = 0, c2 = 0;
        System.out.print("Enter initial row index: ");
        r1 = sc.nextInt();
        System.out.print("Enter initial column index: ");
        c1 = sc.nextInt();
        System.out.print("Enter final row index: ");
        r2 = sc.nextInt();
        System.out.print("Enter final column index: ");
        c2 = sc.nextInt();

        rowPrefixSum(arr);
        colPrefixSum(arr);
        System.out.println("Sum of the region: " + sumRegion(arr, r1, c1, r2, c2));
        System.out.println();
        dispArray(arr);


        sc.close();
    }
}
