package com.company.sort;

import java.util.List;

public class QuickSort {
    private void swap(List<Integer> list, int index1, int index2) {
        Integer temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    private int pivot(List<Integer> list, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex+1; i <= endIndex; i++) {
            if (list.get(i) < list.get(pivotIndex)) {
                swapIndex++;
                swap(list, swapIndex, i);
            }
        }
        swap(list, pivotIndex, swapIndex);
        return swapIndex;
    }

    private List<Integer> quickSortHelper(List<Integer> list, int initIndex, int endIndex) {
        if (initIndex < endIndex) {
            int pivotIndex = pivot(list, initIndex, endIndex);
            quickSortHelper(list, initIndex, pivotIndex-1);
            quickSortHelper(list, pivotIndex+1, endIndex);
        }
        return list;
    }

    public List<Integer> quickSort(List<Integer> list) {
        return quickSortHelper(list, 0, list.size()-1);
    }
}
