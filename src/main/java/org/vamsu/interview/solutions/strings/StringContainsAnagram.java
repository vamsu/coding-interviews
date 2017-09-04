package org.vamsu.interview.solutions.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vamsu on 6/10/17.
 * <p>
 * Find if a string contains anagram of another string
 * <p>
 * Example “coding interview questions” contains an anagram of string “weivretni”, however not for “abcde”.
 * <p>
 * Algorithm
 * <p>
 * Map every character to a prime number
 * Multiple all the prime numbers of the target string.
 * Split the source string
 * For each string in the split check if the size is same as the target
 * If same, multiply all the prime numbers
 * If the result is same return true.
 * else continue with remaining.
 */
public class StringContainsAnagram {

    private Map<Character, Long> primeNumberMap;

    public StringContainsAnagram() {
        this.primeNumberMap = new HashMap<>();
        String alphabets = " abcdefghijklmnopqrstuvwxyz";
        List<Long> primes = generatePrimeNumbers(alphabets.length());
        System.out.println(primes);
        for (int i = 0; i < alphabets.length(); i++) {
            this.primeNumberMap.put(alphabets.charAt(i), primes.get(i));
        }
    }

    public boolean hasAnagram(String source, String target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException();
        }
        if (target.length() > source.length()) {
            return false;
        }
        Long targetAnagramHash = calculatePrimeMultiple(target);
        int start = 0;
        int end = target.length();
        while (end < source.length()) {
            String word = source.substring(start, end);
            Long wordHash = calculatePrimeMultiple(word);
            if (wordHash.equals(targetAnagramHash)) {
                return true;
            }
            start++;
            end++;
        }
        return false;
    }

    private Long calculatePrimeMultiple(String input) {
        Long result = 1L;
        for (int i = 0; i < input.length(); i++) {
            result += result * this.primeNumberMap.get(input.charAt(i));
        }
        return result;
    }

    /**
     * Mod every number from 1 to n
     * It should be only divisible by two numbers 1 and the number itself.
     */
    private List<Long> generatePrimeNumbers(int count) {
        List<Long> primes = new ArrayList<>();
        for (int i = 2; primes.size() < count; i++) {
            int counter = 0;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    counter++;
                }
            }
            if (counter == 1) {
                primes.add((long) i);
            }
        }
        return primes;
    }

    public static void main(String args[]) {
        StringContainsAnagram solution = new StringContainsAnagram();
        System.out.println(solution.hasAnagram("coding interview questions", "weivretni"));
        System.out.println(solution.hasAnagram("coding a questions", "interview"));
        System.out.println(solution.hasAnagram("coding interviex questions", "interview"));
        System.out.println(solution.hasAnagram("coding interviex questions", "oding"));
        System.out.println(solution.hasAnagram("interview", "coding interview questions"));
        System.out.println(solution.hasAnagram("", ""));
    }
}
