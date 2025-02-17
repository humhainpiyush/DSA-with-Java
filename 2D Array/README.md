# 2D Arrays in Java - DSA with Java

## Introduction
A **2D array** (also known as a matrix) is a collection of elements arranged in rows and columns. It is widely used in various applications such as image processing, game development, and dynamic programming.

### **Key Characteristics of 2D Arrays:**
- Elements are stored in a tabular format.
- Indexed using **row index** and **column index**.
- Requires **contiguous memory allocation**.
- Supports efficient **data manipulation and retrieval**.

## Table of Contents
1. [Prefix Sum Optimized Approach](#prefix-sum-optimized-approach)
2. [Prefix Sum Row and Column-wise Approach](#prefix-sum-row-and-column-wise-approach)
3. [Rotating a Matrix by 90 Degrees](#rotating-a-matrix-by-90-degrees)

---

## 1. Prefix Sum Optimized Approach
**Problem Statement:** Given a matrix, preprocess it to answer sum queries efficiently for any submatrix.

### **Approach:**
- Create a **prefix sum matrix** with extra padding.
- Use **prefix sum formula** to compute sums efficiently.
- Answer range sum queries in **constant time**.

### **Code:**
```java
import java.util.Scanner;

public class PrefixOptimized {
    static int [][] sum;
    public static void sumMatrix(int [][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    public static int sumRegion(int r1, int c1, int r2, int c2) {
        r1++; c1++; r2++; c2++;
        return sum[r2][c2] - sum[r1-1][c2] - sum[r2][c1-1] + sum[r1-1][c1-1];
    }
    public static void dispMatrix() {
        System.out.println("The prefix sum final matrix is:");
        for(int i=1; i<sum.length; i++) {
            for(int j=1; j<sum[i].length; j++) {
                System.out.print(sum[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
```
### **Time Complexity:**
- **Preprocessing:** O(m × n)
- **Query Time:** O(1)
### **Space Complexity:**
- O(m × n)

---

## 2. Prefix Sum Row and Column-wise Approach
**Problem Statement:** Given a matrix, preprocess it to compute sum queries using row-wise and column-wise prefix sums.

### **Approach:**
- Compute **row-wise prefix sum**.
- Compute **column-wise prefix sum**.
- Use **precomputed prefix sums** to answer queries efficiently.

### **Code:**
```java
import java.util.Scanner;
public class PrefixSumApproach {
    public static void rowPrefixSum(int [][] arr) {
        int m = arr.length, n = arr[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                arr[i][j] += arr[i][j-1];
            }
        }
    }
    public static void colPrefixSum(int [][] arr) {
        int m = arr.length, n = arr[0].length;
        for(int j = 0; j < n; j++) {
            for(int i = 1; i < m; i++) {
                arr[i][j] += arr[i-1][j];
            }
        }
    }
    public static int sumRegion(int [][] arr, int r1, int c1, int r2, int c2) {
        int sum = arr[r2][c2], up = 0, left = 0, repeatRegion = 0;
        up = (r1 > 0) ? arr[r1-1][c2] : 0;
        left = (c1 > 0) ? arr[r2][c1-1] : 0;
        repeatRegion = (r1 > 0 && c1 > 0) ? arr[r1-1][c1-1] : 0;
        return sum - up - left + repeatRegion;
    }
}
```
### **Time Complexity:**
- **Preprocessing:** O(m × n)
- **Query Time:** O(1)
### **Space Complexity:**
- O(1) (modifies input matrix directly)

---

## 3. Rotating a Matrix by 90 Degrees
**Problem Statement:** Rotate a given matrix by **90 degrees clockwise**.

### **Approach:**
- **Step 1:** Find **transpose** of the matrix.
- **Step 2:** Swap **columns** to get the rotated matrix.

### **Code:**
```java
import java.util.Arrays;
public class RotateMatrix {
    public static void rotateMatrix(int [][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        swap(arr);
    }
    public static void swap(int [][] arr) {
        int cols = arr[0].length;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < cols / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][cols-1-j];
                arr[i][cols-1-j] = temp;
            }
        }
    }
    public static void dispArray(int [][] arr) {
        for(var a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
```
### **Time Complexity:**
- O(m × n) (one pass for transposition, one for swapping columns)
### **Space Complexity:**
- O(1) (modifies input matrix directly)

---

## Conclusion
This tutorial introduced **2D arrays in Java** and covered:
- **Prefix sum optimization** for submatrix sum queries.
- **Row-wise and column-wise prefix sum** approach.
- **Matrix rotation by 90 degrees**.

Understanding these concepts is crucial for solving **grid-based problems** in **DSA** and **competitive programming**. Keep practicing! 🚀


