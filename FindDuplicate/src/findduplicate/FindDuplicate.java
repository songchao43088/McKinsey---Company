/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findduplicate;

/**
 *
 * @author chaosong
 */
public class FindDuplicate {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) {
        // TODO code application logic here
        int[] a = {3, 3, 2, 4, 5, 4, 5, 4, 5, 4, 4, 1, 2, 3, 4, 5,10000,444};
        printQuickSortResult(a);
        QuickSort s = new QuickSort();
        s.sort(a);
        //printQuickSortResult(a);
        int c = count(a);
        numFreq[] b = new numFreq[c];
        b = aggregate(a);
        s.sortNumFreq(b);
        printFinalResult(b);
    }
    
    private static int count(int[] numbers) {
        int j = 0;
        int currentKey = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == currentKey) {
                ;
            } else {
                
                j++;
                currentKey = numbers[i];
                
            }

        }
        
        j++;
        return j;
    }

    private static numFreq[] aggregate(int[] numbers) {
        numFreq[] b = new numFreq[count(numbers)];
        
        int j = 0;
        int currentKey = numbers[0];
        int currentFreq = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == currentKey) {
                currentFreq++;
            } else {
                numFreq a = new numFreq();
                a.key = currentKey;
                a.freq = currentFreq;
                b[j] = a;
                j++;
                currentKey = numbers[i];
                currentFreq = 1;
            }

        }
        numFreq a = new numFreq();
        a.key = currentKey;
        a.freq = currentFreq;
        b[j] = a;
        j++;
        return b;
    }

    private static void printQuickSortResult(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+",");
        }
        System.out.println();
    }
    private static void printFinalResult(numFreq[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i].key +",");
        }
        System.out.println();
    }
}
