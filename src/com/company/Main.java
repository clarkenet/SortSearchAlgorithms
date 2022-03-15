package com.company;

import com.company.datastructure.BinarySearchTree;
import com.company.search.*;
import com.company.sort.MergeSort;
import com.company.sort.QuickSort;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int[] orderedArray = {3, 8, 10, 14, 15, 20, 31, 45, 100, 400, 1000, 1001, 1002};
        int[] unorderedArray = {20, 39, 10, 3, 14, 0, 1002, 11, 100, 5, 300};
        LinearSearch linearSearch = new LinearSearch();
        FrontAndBackSearch frontAndBackSearch = new FrontAndBackSearch();
        BinarySearch binarySearch = new BinarySearch();
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        int elementToSearch = 1002;

        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        System.out.println("---Search Algorithms---");
        printSearch(elementToSearch, linearSearch.linearSearch(unorderedArray, elementToSearch), "Linear Search");
        printSearch(elementToSearch, frontAndBackSearch.frontBackSearch(unorderedArray, elementToSearch), "Front And Back Search");
        printSearch(elementToSearch, binarySearch.iterativeBinarySearch(orderedArray, elementToSearch), "Iterative Binary Search");
        printSearch(elementToSearch, binarySearch.recursiveBinarySearch(orderedArray, elementToSearch), "Recursive Binary Search");
        printSearch(elementToSearch, fibonacciSearch.fibonacciSearch(orderedArray, elementToSearch), "Fibonacci Search");

        System.out.println("---Search Pattern Algorithms---");
        KMPPatternSearch kmpPatternSearch = new KMPPatternSearch();
        System.out.println("Text indexes found: " +
                kmpPatternSearch.KMPSearch("aaacaaacaaacaaaa", "aaac")
                        .stream().map(Object::toString).collect(Collectors.joining(", ")));

        System.out.println("---Sort Algorithms---");
        List<Integer> unorderedList = IntStream.of(unorderedArray).boxed().collect(Collectors.toList());
        printSort("MergeSort", mergeSort.mergeSort(unorderedList));
        printSort("QuickSort", quickSort.quickSort(unorderedList));

        System.out.println("---Datastructures---\n");

        System.out.println("---BinarySearchTree---");
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(3);
        binarySearchTree.insert(8);
        binarySearchTree.insert(0);
        binarySearchTree.insert(7);
        System.out.println("Contains 5: " + binarySearchTree.contains(5));
        System.out.println("Contains 3: " + binarySearchTree.contains(3));
        printSort("Breadth First Search", binarySearchTree.bfs());
        printSort("Deep First Search Pre-order", binarySearchTree.dfsPreOrder());
        printSort("Deep First Search Post-order", binarySearchTree.dfsPostOrder());
        printSort("Deep First Search In-order", binarySearchTree.dfsInOrder());
    }

    private static void printSearch(int elementToSearch, int index, String searchType) {
        if (index != -1) {
            System.out.println(searchType + " - Element: " + elementToSearch + " found at index: " + index);
        } else {
            System.out.println(searchType + " - Element: " + elementToSearch + " not found");
        }
    }

    private static void printSort(String algorithm, List<Integer> list) {
        System.out.println(algorithm + ": " + list.stream().map(Objects::toString).collect(Collectors.joining(", ")));
    }
}
