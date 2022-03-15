package com.company.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private List<Integer> mergeSortHelper(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            result.add(list2.get(j));
            j++;
        }
        return result;
    }

    public List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int middle = list.size()/2;
        List<Integer> left = mergeSort(list.subList(0, middle));
        List<Integer> right = mergeSort(list.subList(middle, list.size()));
        return mergeSortHelper(left, right);
    }
}
