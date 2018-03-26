package ineed.to.practice;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Chain {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {5,2,4,6,3,7}));
        System.out.println(solution(new int[] {5,2,4,6,3}));
        System.out.println(solution(new int[] {5,2,4,6,3,7,1,8}));
    }

    public static int solution(int[] A) {
        if (A.length < 5) return -1;
        TreeMap<Integer, Integer> firstValue2Index = new TreeMap<Integer, Integer>();
        for (int i = 1; i < A.length-3; i++) {
            firstValue2Index.put(A[i], i);
        }
        TreeMap<Integer, Integer> secondValue2Index = new TreeMap<Integer, Integer>();
        for (int i = 3; i < A.length-1; i++) {
            secondValue2Index.put(A[i], i);
        }
        Iterator<Map.Entry<Integer, Integer> > iter1 = firstValue2Index.entrySet().iterator();
        Iterator<Map.Entry<Integer, Integer> > iter2 = secondValue2Index.entrySet().iterator();
        Map.Entry<Integer, Integer> entry1 = iter1.next();
        Map.Entry<Integer, Integer> entry2 = iter2.next();
        do {
            int min1 = entry1.getKey(), min2 = entry2.getKey();
            int distance = entry2.getValue() - entry1.getValue();
            if (distance > 1) return min1 + min2;
            if (min2 > min1) entry1 = iter1.next();
            else entry2 = iter2.next();
        } while (iter1.hasNext() && iter2.hasNext());

        return -1;
    }
}
