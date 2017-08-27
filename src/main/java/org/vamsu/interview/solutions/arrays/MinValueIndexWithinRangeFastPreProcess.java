package org.vamsu.interview.solutions.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vamsu on 6/10/17.
 * Find the min value within the given range of an array.
 * <p>
 * You can pre process the array, the query() method should be as fast as possible.
 */
public class MinValueIndexWithinRangeFastPreProcess {
    public static class Range {
        private Integer start;
        private Integer end;

        public Range(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        private boolean isValid() {
            return this.start <= this.end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Range range = (Range) o;

            if (start != null ? !start.equals(range.start) : range.start != null) return false;
            return end != null ? end.equals(range.end) : range.end == null;
        }

        @Override
        public int hashCode() {
            int result = start != null ? start.hashCode() : 0;
            result = 31 * result + (end != null ? end.hashCode() : 0);
            return result;
        }
    }

    public static class MinArray {
        private Map<Range, Integer> cache;

        public MinArray(int[] arr) {
            preProcess(arr);
        }

        private void preProcess(int[] arr) {
            this.cache = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                this.cache.put(new Range(i, i), i);
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    Range prevRange = new Range(i, j - 1);
                    Range currentRange = new Range(i, j);

                    Integer prevMinIndex = this.cache.get(prevRange);

                    if (arr[j] < arr[prevMinIndex]) {
                        this.cache.put(currentRange, j);
                    } else {
                        this.cache.put(currentRange, prevMinIndex);
                    }
                }
            }
        }

        public Integer query(Range range) {
            if (!range.isValid()) {
                throw new IllegalArgumentException();
            }
            return this.cache.get(range);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 4, -1, -5, 2, -2, 0, 10, 19};
        MinValueIndexWithinRangeFastPreProcess.MinArray minArray = new MinArray(arr);
        System.out.println("Min value from 0 and 5, " + minArray.query(new Range(0, 5)));
        System.out.println("Min value from 3 and 4, " + minArray.query(new Range(3, 4)));
        System.out.println("Min value from 6 and 8, " + minArray.query(new Range(6, 8)));
        System.out.println("Min value from 0 and 0, " + minArray.query(new Range(0, 0)));
        try {
            minArray.query(new Range(10, 0));
        } catch (IllegalArgumentException e) {
            System.out.println("Min value from 10 and 0, IllegalArgumentException thrown");
        }
    }
}
