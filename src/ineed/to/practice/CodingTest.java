package ineed.to.practice;

import java.util.*;

public class CodingTest {
    public static void main(String[] args) {
        System.out.println(searchRange(Arrays.asList(4, 7, 7, 7, 8, 10, 10), 3));
        System.out.println(searchRange(Arrays.asList(4, 7, 7, 7, 8, 10, 10), 5));
        System.out.println(searchRange(Arrays.asList(4, 7, 7, 7, 8, 10, 10), 4));
        System.out.println(searchRange(Arrays.asList(4, 7, 7, 7, 8, 10, 10), 7));
        System.out.println(searchRange(Arrays.asList(4, 7, 7, 7, 8, 10, 10), 8));
        System.out.println(searchRange(Arrays.asList(4, 7, 7, 7, 8, 10, 10), 10));
        System.out.println(searchRange(Arrays.asList(4, 4, 7, 7, 8, 10, 10), 4));
        System.out.println(searchRange(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10), 3));
        System.out.println(searchRange(Arrays.asList(1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10), 3));
    }


    static int[] rotate(int[] input, int pivot) {
        if (pivot == 0) return input;
        int counter = 0, swapValue = input[0], swapTarget = input.length - pivot;
        while (counter < input.length) {
            int[] updateResult = update(input, swapValue, swapTarget, pivot);
            swapValue = updateResult[0];
            swapTarget = updateResult[1];
            counter++;
        }
        return input;
    }

    private static int[] update(int[] input, int swapValue, int swapIndex, int pivot) {
        int[] result = new int[2];
        result[0] = input[swapIndex];
        input[swapIndex] = swapValue;
        result[1] = swapIndex < pivot ? input.length - pivot + swapIndex : swapIndex - pivot;
        return result;
    }

    static ArrayList<Integer> maxset(List<Integer> a) {

        int index = 0, maxStart = 0, maxEnd = 0;
        long maxSum = 0;
        while (index < a.size()) {
            long subSum = -1;
            int endIndex = index;
            for (; endIndex < a.size() && a.get(endIndex) >= 0; endIndex++) {
                subSum = Math.max(0, subSum) + a.get(endIndex);
            }
            if (subSum > maxSum
                    || (subSum == maxSum && ((endIndex - index) > (maxEnd - maxStart)))) {
                maxSum = subSum;
                maxStart = index;
                maxEnd = endIndex;
            }
            index = index == endIndex ? endIndex + 1 : endIndex;
        }
        ArrayList<Integer> result = new ArrayList<Integer>(maxEnd - maxStart + 1);
        for (int i = maxStart; i < maxEnd; i++) {
            result.add(a.get(i));
        }
        return result;
    }

    static int power(String a) {
        byte[] bytes = a.getBytes();
        for (byte byyt : bytes) {
            System.out.print(byyt);
            if (byyt != (byte) 1) return 0;
        }
        System.out.println();
        return 1;
    }

    static void getSetBits(long number) {
        int bits = 0;
        long i = 0x00000001L;
        while (i <= number) {
            bits += ((number & i) == i) ? 1 : 0;
            i = i << 1;
        }
        System.out.println(number + ": " + bits);
    }

    private static boolean isPrime(int num) {
        if (num < 4) return true;
        for (int i = 2; i <= Math.ceil(Math.sqrt(num)); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private static boolean isStepper(int num) {
        int octal = 1, previousDigit = 0, currentDigit;
        while (num / octal >= 1) {
            currentDigit = (num % (octal * 10)) / octal;
            if (octal != 1 && Math.abs(currentDigit - previousDigit) != 1) return false;
            previousDigit = currentDigit;
            num -= num % (octal * 10);
            octal *= 10;
        }
        return true;
    }

    private static ArrayList<Integer> getNumbers(int a) {
        String numStr = String.valueOf(a);
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int size = 1; size <= numStr.length(); size++) {
            for (int i = 0; i <= numStr.length() - size; i++) {
                numbers.add(Integer.parseInt(numStr.substring(i, i + size)));
            }
        }
        return numbers;
    }


    public int solution(int[] A) {
        if (A == null || A.length == 0) return 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i; j < A.length; j++) {
                result = Math.max(result, getSumDistance(A, i, j));
            }
        }
        return result;
    }

    private int getSumDistance(int[] A, int idx1, int idx2) {
        return A[idx1] + A[idx2] + (idx2 - idx1);
    }

    public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int leftBound = searchBound(a, b, true);
        int rightBound = searchBound(a, b, false);
        ArrayList<Integer> range = new ArrayList<Integer>(2);
        range.add(leftBound);
        range.add(rightBound);
        return range;
    }

    private static int searchBound(List<Integer> a, int b, boolean searchLeft) {
        int low = 0, high = a.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean midLeftIsB = mid > 0 && a.get(mid - 1) == b;
            boolean midRightIsB = mid < (a.size() - 1) && a.get(mid + 1) == b;
            int current = a.get(mid);
            if (current < b || (!searchLeft && current == b && midRightIsB)) {
                low = mid + 1;
            } else if (current > b || (searchLeft && current == b && midLeftIsB)) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
