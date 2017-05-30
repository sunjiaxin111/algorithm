package chapterOne.three;

import stdlib.StdIn;
import stdlib.StdOut;

/*************************************************************************
 *  Compilation:  javac Stats.java
 *  Execution:    java Stats < input.txt
 *  Dependencies: Bag.java StdIn.java StdOut.java
 *
 *  Reads in a sequence of real numbers from standard input and 
 *  computes their mean and standard deviation.
 * 
 *  % java Stats
 *  100 99 101 120 98 107 109 81 101 90
 *  Mean:    100.60
 *  Std dev: 10.51
 *  
 *************************************************************************/

public class Stats {
    public static void main(String[] args) {

        // read in numbers
        Bag<Double> numbers = new Bag<>();
        /*while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }*/
        numbers.add(100.0);
        numbers.add(99.0);
        numbers.add(101.0);
        numbers.add(120.0);
        numbers.add(98.0);
        numbers.add(107.0);
        numbers.add(109.0);
        numbers.add(81.0);
        numbers.add(101.0);
        numbers.add(90.0);
        int N = numbers.size();

        // compute mean
        double sum = 0.0;
        for (double x : numbers)
            sum += x;
        double mean = sum/N;

        // compute standard deviation
        sum = 0.0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum/(N-1));

        StdOut.printf("Mean:    %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
