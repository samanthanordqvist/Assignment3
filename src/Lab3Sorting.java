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

    // Quicksort part of an array
    public static int[] quickSort(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }
    private static int[] quickSort(int[] array, int begin, int end) {

        int i = partition(array, begin, end);

        if (begin < i -1)
            quickSort(array, begin, i -1);

        if (end > i)
            quickSort(array, i, end);

        return array;
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[(begin + end) /2];
        int low = begin;
        int high = end;

        while (low <= high) {
            while (array[low] < pivot) low++;
            while (array[high] > pivot) high--;

            if (low <= high) {
                swap(array, low, high);
                low++;
                high--;
            }
        }
        return low;
    }
    // Swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

    // Mergesort.

    public static int[] mergeSort(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    // Mergesort part of an array
    private static int[] mergeSort(int[] array, int begin, int end) {
        if (begin > end) return new int[0];
        if (begin == end) {
            int[] result = {array[begin]};
            return result;
        }
        int mid = (begin+end)/2;
        mergeSort(array, begin, mid);
        mergeSort(array, mid + 1, end);
        return merge(begin, mid, end, array);
    }

    // Merge two sorted arrays into one
    private static int[] merge(int begin, int mid, int end, int[] arr) {
        int[] tempArr = new int[arr.length];
        for (int i = begin; i <= end; i++) tempArr[i] = arr[i];
        int left = begin;
        int right = mid + 1;
        int current = begin;
        while (left <= mid && right <= end) {
            arr[current++] = tempArr[left] <= tempArr[right] ? tempArr[left++] : tempArr[right++];
        }
        int leftovers = mid - left;
        for (int i = 0; i <= leftovers; i++) arr[current + i] = tempArr[left + i];
        return arr;
    }



    public static void heapSort(int[] array) {
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
}
