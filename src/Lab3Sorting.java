import java.util.Arrays;

public class Lab3Sorting {
    /** This is the skeleton code for the sorting algorithms
     * implementations for Assignment 1. The methods that
     * are currently not implemented throw the
     * UnsupportedOperationException. You may add more
     * methods to the class, but please do not change
     * the names or types of the existing methods. */

    // Insertion sort.

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Quicksort.

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Quicksort part of an array
    private static void quickSort(int[] array, int begin, int end) {
        // Base case.
        if (begin >= end)
            return;

        // Partition the array.
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot);
        quickSort(array, pivot, end);

        // Now recursively quicksort the two partitions.
    }

    // Partition part of an array, and return the index where the pivot
    // ended up.

    private static int partition(int[] array, int begin, int end) {
        // array[begin] will be the pivot element
        if (end == begin)
            return 0;
        int pivot = array[begin];
        int low = begin - 1;
        int high = end + 1;
        while (low < high) {
            while (low < high && array[++low] < array[pivot])
                ;
            while (high > begin && array[++high] > array[pivot])
                ;
            if (low < high)
                swap(array, low, high);
            else
                break;
        }
        return low;
    }

    // Swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }

    // Mergesort.

    public static int[] mergeSort(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    // Mergesort part of an array
    private static int[] mergeSort(int[] array, int begin, int end) {
        // Base case: array of length 0 or 1.
        if (begin > end) return new int[0];
        if (begin == end) {
            int[] result = {array[begin]};
            return result;
        }

        // Midpoint of the array
        int mid = (begin+end)/2;

        // Recursively sort both halves of the array,
        // then merge the results.
        throw new UnsupportedOperationException();
    }

    // Merge two sorted arrays into one
    private static int[] merge(int[] left, int[] right) {
        // The result array
        int[] result = new int[left.length + right.length];
        // How far we have got in the result array
        int nextResult = 0;
        // How far we have got in the left array
        int nextLeft = 0;
        // How far we have got in the right array
        int nextRight = 0;

        // Idea: repeatedly copy one element from either the left or right array to the result array.
        throw new UnsupportedOperationException();
    }


    public void heapSort(int[] array) {
        int length = array.length;

        // Creates the heap.
        for(int i = length/2 -1; i >= 0; i--) {
            heapify(array, i, length);
        }

        // Swaps the current root with the last element of the array
        // and decreases the length of that.
        for(int i = array.length -1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            length -= 1;
            heapify(array, 0, length);
        }
    }

    private static void heapify(int[] array, int index, int heapSize) {
        int left = index * 2 + 1;   // Position of the left element.
        int right = index * 2 + 2;  // Position the the right element.
        int largest = index;    // Initialises the largest element.

        // Checks if the left element is bigger than the size of the heap.
        if(left < heapSize && array[left] > array[largest]) {
            largest = left;
        }

        // Checks if the right element is bigger than the size of the heap.
        if(right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        //  If the largest node is not the biggest one it swaps with the left and right node.
        if(largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;
            heapify(array, largest, heapSize);
        }
    }

    public static void main(String[] args) {
        // Put code here to try out your algorithms
        int[] example1 = new int[] {4, 5, 6, 3, 2, 1};


        // Insertion sort performs sorting in place, and it will
        // modify the original array;
        insertionSort(example1);
        System.out.println(Arrays.toString(example1));
    }
}