package ineed.to.practice;

import java.util.HashSet;
import java.util.Set;

public class Branches {
    public static int count(int[] tree) {
        Set<Integer> uniqueBranches = new HashSet<Integer>();
        for (int node: tree) {
            if (node >= 0) uniqueBranches.add(node);
        }
        return uniqueBranches.size();
    }

    public static void main(String[] args) {
        System.out.println(Branches.count(new int[] { 1, 3, 1, -1, 3 }));
    }

}