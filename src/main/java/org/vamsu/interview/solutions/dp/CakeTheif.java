package org.vamsu.interview.solutions.dp;

/**
 * Created by vamsu on 5/30/17.
 */
public class CakeTheif {

    public static class CakeType {
        int weight;
        int value;

        CakeType(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        permute("abc","");
//        CakeType[] cakeTypes = new CakeType[]{
//                new CakeType(7, 160),
//                new CakeType(3, 90),
//                new CakeType(2, 15),
//        };
//        System.out.println(maxDuffelBag(cakeTypes,
//                20, 0, Integer.MIN_VALUE));
    }

    private static int maxDuffelBag(CakeType[] cakeTypes,
                                    int currentCapacity, int currentValue,
                                    int maxValue) {
        if (currentCapacity <= 0) {
            System.out.println(maxValue);
            return maxValue;
        }
        for (CakeType cakeType : cakeTypes) {
            if (currentCapacity - cakeType.weight < 0) {
                continue;
            }
            currentCapacity = currentCapacity - cakeType.weight;
            currentValue += cakeType.value;
            if (currentValue > maxValue) {
                maxValue = currentValue;
            }
            maxDuffelBag(cakeTypes, currentCapacity, currentValue, maxValue);
        }
        System.out.println(maxValue);
        return maxValue;
    }

    private static void permute(String input, String result) {
        if (result.length() == input.length()) {
            System.out.println(result);
            return;
        }
        for (Character ch : input.toCharArray()) {
            permute(input, result + ch);
        }
    }
}
