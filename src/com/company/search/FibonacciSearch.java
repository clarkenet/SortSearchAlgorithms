package com.company.search;

/*
Uses divide and conquer approach. It uses addition or subtraction to get a smaller range (Unlike BinarySearch
where we divide the elements into equal halves)
Fibonacci formula: Fibo(N) = Fibo(N-1) + Fibo(N-2) | 0, 1, 1, 2, 3, 5, 8, 13...
Requires sorted data (More than 1 element)
Time complexity: O(log(n))
Space complexity: O(1)
 */
public class FibonacciSearch {
    public int fibonacciSearch(int[] array, int elementToSearch) {
        //Fibonacci numbers initialization
        int fibonacciMinus1 = 0;
        int fibonacciMinus2 = 1;
        int fibonacciNumber = fibonacciMinus1 + fibonacciMinus2;

        //Fill the Fibonacci series until getting the closest number above the array length
        while (fibonacciNumber < array.length) {
            fibonacciMinus2 = fibonacciMinus1;
            fibonacciMinus1 = fibonacciNumber;
            fibonacciNumber = fibonacciMinus1 + fibonacciMinus2;
        }

        //Marks the eliminated range from front
        int offset = -1;

        //While there are elements to be inspected
        //Note that we compare array[Fib-2] with elementToSearch
        //When FibNum becomes 1, Fib-2 becomes 0
        while (fibonacciNumber > 1) {
            //Check if Fib-2 is a valid location
            int i = Math.min(offset + fibonacciMinus2, array.length - 1);

            //If elementToSearch is grater than the value at index Fib-2
            //Cut the array from offset to i
            if (array[i] < elementToSearch) {
                fibonacciNumber = fibonacciMinus1;
                fibonacciMinus1 = fibonacciMinus2;
                fibonacciMinus2 = fibonacciNumber - fibonacciMinus1;
                offset = i;
            //If elementToSearch is less than the value at index Fib-2
            //Cut the array after i+1
            } else if (array[i] > elementToSearch) {
                fibonacciNumber = fibonacciMinus2;
                fibonacciMinus1 = fibonacciMinus1 - fibonacciMinus2;
                fibonacciMinus2 = fibonacciNumber - fibonacciMinus1;
            //Element found
            } else {
                return i;
            }
        }

        //If one element remains, compare it.
        //It happens when array.length equals fibNum
        if (fibonacciMinus1 == 1 && array[offset + 1] == elementToSearch) {
            return offset + 1;
        }

        return -1;
    }
}
