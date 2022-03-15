package com.company.search;

/*
Improves the Linear Search since this one performs 2 checks per iteration (front and back)
Works with unordered data
Time complexity: 0(n/2) = O(n)
Space complexity: O(1)
 */
public class FrontAndBackSearch {
    public int frontBackSearch(int[] array, int elementToSearch) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;

        //For each iteration checks front and rear positions
        while (firstIndex <= lastIndex) {
            if (array[firstIndex] == elementToSearch) {
                return firstIndex;
            } else if (array[lastIndex] == elementToSearch) {
                return lastIndex;
            }
            firstIndex++;
            lastIndex--;
        }
        return -1;
    }
}
