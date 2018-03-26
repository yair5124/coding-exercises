package ineed.to.practice;

import java.util.Arrays;

public class PaperStrip {
    public static int minPieces(int[] original, int[] desired) {
        int minPieces = 0;
        int begin = 0;
        while (begin < original.length) {
            int end = original.length-1;
            boolean match = false;
            while (end >= begin) {
                if (hasMatchingPiece(original, desired, begin, end)) {
                    minPieces++;
                    begin = end + 1;
                    match = true;
                } else {
                    end--;
                }
            }
            if (!match) begin++;
        }
        return minPieces;
    }

    private static boolean hasMatchingPiece(int[] original, int[] desired, int begin, int end) {
        int size = end - begin + 1, desiredIndex = 0, matches = 0;
        while (desiredIndex < desired.length && begin < original.length) {
            if (desired[desiredIndex] != original[begin]) {
                desiredIndex++;
            } else {
                while (desiredIndex < desired.length && begin < original.length
                        && desired[desiredIndex++] == original[begin++]) {
                    matches++;
                }
                return matches == size;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] original = new int[] { 1, 4, 3, 2 };
        int[] desired = new int[] { 1, 2, 4, 3 };
        System.out.println(PaperStrip.minPieces(original, desired));
        original = new int[] { 5, 1, 4, 2, 3 };
        desired = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(PaperStrip.minPieces(original, desired));
    }
}