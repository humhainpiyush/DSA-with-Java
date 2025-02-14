# 1D Arrays in Java - DSA with Java

## Introduction
A **1D array** is a linear data structure that stores a fixed-size sequence of elements of the same type. It provides efficient indexing but requires contiguous memory allocation. Below are some key characteristics of **1D arrays in Java**:

- **Fixed Size**: The size of an array is defined at the time of creation and cannot be changed dynamically.
- **Efficient Access**: Elements can be accessed in constant time using an index.
- **Contiguous Memory Allocation**: All elements are stored in consecutive memory locations.
- **Homogeneous Elements**: A 1D array can store elements of the same data type.
- **Zero-Based Indexing**: The first element is accessed using index `0`.
- **Mutable Elements**: Array elements can be updated after initialization.

In this tutorial, we will cover fundamental operations on **1D arrays** using Java.

## Table of Contents
1. [Checking for Duplicates](#checking-for-duplicates)
2. [Finding a Missing Number](#finding-a-missing-number)
3. [Checking if an Array is Palindromic](#checking-if-an-array-is-palindromic)
4. [Reversing an Array](#reversing-an-array)

---

## 1. Checking for Duplicates
**Problem Statement:** Given an array, determine whether it contains duplicate elements.

### **Approach:**
- Use nested loops to compare each element with others.
- If a duplicate is found, print the duplicate value.

### **Code:**
```java
public class Duplicate {
    public static void main(String[] args) {
        int [] arr = {1,2,2,3,3};
        int n = arr.length;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(arr[i] == arr[j]) {
                    System.out.println("Duplicate: " + arr[i]);
                    break;
                }
            }
        }
    }
}
```
### **Time Complexity:**
- **O(n²)** due to nested loops.
### **Space Complexity:**
- **O(1)** (constant extra space used).

---

## 2. Finding a Missing Number
**Problem Statement:** Given an array of `n` numbers from `1` to `n+1` (with one missing), find the missing number.

### **Approach 1:** Using Sum Formula
- Compute the sum of first `n+1` natural numbers.
- Subtract the sum of array elements from this sum to get the missing number.

### **Code:**
```java
public class Missing {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int size = arr.length;

        int sumNatural = (size + 1) * (size + 2) / 2;
        int sum = 0;
        for(int i = 0; i < size; i++){
            sum += arr[i];
        }
        System.out.println("The missing number is: " + (sumNatural - sum));
    }
}
```
### **Alternative Approach:**
Another approach uses iterative sum computation:
```java
static int missingNumber(int a[], int n) {
    int total = 1;
    for (int i = 2; i <= (n + 1); i++) {
        total += i;
        total -= a[i - 2];
    }
    return total;
}
```
### **Time Complexity:**
- **O(n)** (single loop iteration).
### **Space Complexity:**
- **O(1)** (no extra space used).

---

## 3. Checking if an Array is Palindromic
**Problem Statement:** Determine whether a given array is a palindrome (reads the same forward and backward).

### **Approach:**
- Compare the first and last elements, then the second and second-last, and so on.
- If a mismatch is found, the array is not a palindrome.

### **Code:**
```java
public class Palindrome {
    public static void main(String[] args) {
        int [] arr = {1,2,3,2,1};
        int size = arr.length;
        int flag = 0;
        for(int i = 0; i < size / 2; i++){
            if(arr[i] != arr[size - 1 - i]){
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
```
### **Time Complexity:**
- **O(n)** (single loop iteration).
### **Space Complexity:**
- **O(1)** (constant extra space used).

---

## 4. Reversing an Array
**Problem Statement:** Reverse the given array in-place.

### **Approach:**
- Swap the first and last elements, second and second-last, and so on.

### **Code:**
```java
public class Reversal {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int size = arr.length;
        for(int i = 0; i < size / 2; i++){
            int temp = arr[i];
            arr[i] = arr[size - i - 1];
            arr[size - i - 1] = temp;
        }
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
```
### **Time Complexity:**
- **O(n)** (single loop iteration).
### **Space Complexity:**
- **O(1)** (no extra space used).

---

## Conclusion
This tutorial provides a foundation for working with **1D arrays in Java**. We covered:
- Detecting duplicates
- Finding missing numbers
- Checking palindromic arrays
- Reversing an array

This is just the beginning! More advanced topics on arrays, searching, and sorting will be added soon.

Stay tuned and keep practicing! 🚀


