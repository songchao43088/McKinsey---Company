/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findduplicate;

/**
 *
 * @author chaosong
 */
public class QuickSort {

    private int[] numbers;
    private int number;
    private numFreq[] numFreqs;

    

    public void sort(int[] values) {
        // Check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }
    
    public void sortNumFreq(numFreq[] values) {
        // Check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.numFreqs = values;
        number = values.length;
        quicksortNumFreq(0, number - 1);
    }
    
    private void quicksortNumFreq(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        numFreq pivot = numFreqs[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numFreqs[i].freq > pivot.freq) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numFreqs[j].freq < pivot.freq) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchangeNumFreq(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j) {
            quicksortNumFreq(low, j);
        }
        if (i < high) {
            quicksortNumFreq(i, high);
        }
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j) {
            quicksort(low, j);
        }
        if (i < high) {
            quicksort(i, high);
        }
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    private void exchangeNumFreq(int i, int j) {
        numFreq temp = numFreqs[i];
        numFreqs[i] = numFreqs[j];
        numFreqs[j] = temp;
    }
}
