import java.util.Scanner;

public class PrefixOptimized
{
    static int [][] sum;

    public static void sumMatrix(int [][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m+1][n+1];//padded matrix with one extra row and a column
        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public static int sumRegion(int r1, int c1, int r2, int c2)
    {
        r1++; c1++; r2++; c2++;
        return sum[r2][c2] - sum[r1-1][c2] - sum[r2][c1-1] + sum[r1-1][c1-1];
    }

    public static void dispMatrix(){
        System.out.println("The prefix sum final matrix is : ");    
        for(int i=1;i<sum.length;i++){    
            for(int j=1;j<sum[i].length;j++){    
                System.out.print(sum[i][j] + "  ");  
            }
            System.out.println();    
        }  
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the no.of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter the no.of columns: ");
        int c = sc.nextInt();
        int [][] matrix = new int[r][c];
        System.out.println("Enter elements: ");
        for(int i = 0; i<r; i++)
        {
            for(int j = 0; j<c; j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }

        sumMatrix(matrix);

        System.out.print("Enter r1:");
        int r1 = sc.nextInt();
        System.out.print("Enter c1:");
        int c1 = sc.nextInt();
        System.out.print("Enter r2:");
        int r2 = sc.nextInt();
        System.out.print("Enter c2:");
        int c2 = sc.nextInt();

        System.out.println("The sum of the region: " + sumRegion(r1, c1, r2, c2));
        sc.close();

        dispMatrix();



    }
}