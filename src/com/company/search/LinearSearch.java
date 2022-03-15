package com.company.search;

/*
* Te easiest search algorithm to implement but the most inefficient one
* Works with unsorted data
* Time complexity: O(n)
* Space complexity: O(1)
* */
public class LinearSearch {
    public int linearSearch(int[] array, int elementToSearch) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == elementToSearch)
                return index;
        }
        return -1;
    }
}
