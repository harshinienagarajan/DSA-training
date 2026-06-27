package dsa.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // 1. Calculate Mid
    static int calculateMid(int low, int high) {
        return low + (high - low) / 2;
    }

    // 2. Complex Target with Mid (Binary Search)
    static int binarySearch(List<Integer> arr, int target) {
        int low = 0, high = arr.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) == target)
                return mid;
            else if (arr.get(mid) < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    // 3. Print N Natural Numbers Using Recursion
    static void printNatural(int n) {
        if (n == 0)
            return;

        printNatural(n - 1);
        System.out.print(n + " ");
    }

    // 4. Sum of First N Natural Numbers Using Recursion
    static int sumNatural(int n) {
        if (n == 0)
            return 0;

        return n + sumNatural(n - 1);
    }

    // 5. Nth Fibonacci Using Recursion (Optimized)
    static long fibonacci(int n, long[] dp) {
        if (n <= 1)
            return n;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
    }

    // 6. Array of Squares
    static List<Integer> squareArray(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();

        for (int num : arr)
            result.add(num * num);

        return result;
    }

    // 7. Count Factors
    static int countFactors(int n) {
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i)
                    count++;
                else
                    count += 2;
            }
        }

        return count;
    }

    // 8. Prime Check
    static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // 1. Mid Calculation
        int low = 10, high = 20;
        System.out.println("Mid = " + calculateMid(low, high));
        System.out.println();

        // 2. Binary Search
        List<Integer> arr = Arrays.asList(2, 4, 6, 8, 10, 12, 14);
        int target = 10;

        int index = binarySearch(arr, target);

        if (index != -1)
            System.out.println("Target found at index: " + index + "\n");
        else
            System.out.println("Target not found\n");

        // 3. Print N Natural Numbers
        int n = 10;
        System.out.print("Natural Numbers: ");
        printNatural(n);
        System.out.println("\n");

        // 4. Sum of First N Natural Numbers
        System.out.println("Sum of first " + n + " natural numbers = " + sumNatural(n) + "\n");

        // 5. Nth Fibonacci
        int fibN = 10;
        long[] dp = new long[fibN + 1];
        Arrays.fill(dp, -1);

        System.out.println(fibN + "th Fibonacci Number = " + fibonacci(fibN, dp) + "\n");

        // 6. Array of Squares
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = squareArray(nums);

        System.out.print("Squares Array: ");
        for (int x : squares)
            System.out.print(x + " ");
        System.out.println("\n");

        // 7. Count Factors
        int num = 36;
        System.out.println("Number of factors of " + num + " = " + countFactors(num) + "\n");

        // 8. Prime Check
        int primeNum = 29;

        if (isPrime(primeNum))
            System.out.println(primeNum + " is Prime");
        else
            System.out.println(primeNum + " is Not Prime");
    }
}
