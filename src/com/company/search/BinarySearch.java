package com.company.search;

/*
The most widely used Search Algorithm.
Requires sorted data
Time complexity: O(log(n))
Space Complexity: O(1) and O(log(n))
 */
public class BinarySearch {
    public int iterativeBinarySearch(int[] array, int elementToSearch) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;

        while (firstIndex <= lastIndex) {
            //Example (0 + 5) / 2 = 2 | (2 + 4) / 2 = 3
            int middleIndex = (firstIndex + lastIndex) / 2;

            //If element is found in the middle, return the index (This the goal)
            if (array[middleIndex] == elementToSearch) {
                return middleIndex;
            //If middle element is smaller, move the iteration to the second half of the array
            //Ex. mid = 2, elem = 4 then start looking from firstIndex = 2 + 1
            } else if (array[middleIndex] < elementToSearch) {
                firstIndex = middleIndex + 1;
            //If middle element is grater, move the iteration to the first half of the array
            //Ex. mid = 5, elem = 3 then start looking until lastIndex = 5 - 1
            } else if (array[middleIndex] > elementToSearch) {
                lastIndex = middleIndex - 1;
            }
        }
        //If element is not present
        return -1;
    }

    private int recursiveBinarySearchHelper(int[] array, int firstIndex, int lastIndex, int elementToSearch) {
        if (firstIndex <= lastIndex) {
            //Example 0 + (6 - 0) / 2 = 3 | 3 + (3 - 3) / 2 = 3
            int middleIndex = firstIndex + (lastIndex - firstIndex) / 2;

            //If element is found in the middle, return the index (This the goal)
            if (array[middleIndex] == elementToSearch) {
                return middleIndex;
            //If middle element is smaller, move the iteration to the second half of the array
            //Ex. mid = 2, elem = 4 then start looking from firstIndex = 2 + 1
            } else if (array[middleIndex] < elementToSearch) {
                return recursiveBinarySearchHelper(array, middleIndex + 1, lastIndex, elementToSearch);
            //If middle element is grater, move the iteration to the first half of the array
            //Ex. mid = 5, elem = 3 then start looking until lastIndex = 5 - 1
            } else if (array[middleIndex] > elementToSearch) {
                return recursiveBinarySearchHelper(array, firstIndex, middleIndex - 1, elementToSearch);
            }
        }
        //If element is not present. Base condition
        return -1;
    }

    public int recursiveBinarySearch(int[] array, int elementToSearch) {
        return recursiveBinarySearchHelper(array, 0, array.length - 1, elementToSearch);
    }
}
