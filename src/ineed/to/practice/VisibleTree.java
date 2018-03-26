package ineed.to.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class VisibleTree {

    class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }

    public int solution(Tree T) {
        List<Integer> path = new ArrayList<Integer>();
        Stack<Tree> s = new Stack<Tree>();
        s.add(T);
        int maxInPath = T.x;
        while (!s.isEmpty()) {
            Tree tree = s.pop();
            if (tree.x >= maxInPath) path.add(tree.x);
            if (tree.x > maxInPath) maxInPath = tree.x;
            if (tree.r != null) s.add(tree.r);
            if (tree.l != null) s.add(tree.l);
        }
        return path.size();
    }
}