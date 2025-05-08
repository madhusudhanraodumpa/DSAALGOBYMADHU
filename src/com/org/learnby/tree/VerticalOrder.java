package com.org.learnby.tree;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrder {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right=new TreeNode(7);
        VerticalOrder v= new VerticalOrder();
        v.verticalTraversal(root);

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minL = Integer.MAX_VALUE;
        int maxL = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Pair<TreeNode,Integer> p = q.peek();
            q.poll();
            TreeNode temp = p.first;

            List<Integer> list = map.containsKey(p.second) ? map.get(p.second) : new ArrayList<>();
            list.add(temp.data);
            map.put(p.second, list);

            minL = Math.min(minL, p.second);
            maxL = Math.max(maxL, p.second);

            if (temp.right != null) {
                q.add(new Pair(temp.right, p.second + 1));
            }
            if (temp.left != null) {
                q.add(new Pair(temp.left, p.second - 1));

            }

        }

        for (int i = minL; i <= maxL; i++) {
            List<Integer> l = map.get(i);
           String s =  l.stream().map(e->e.toString()).collect(Collectors.joining());
            System.out.println(s);
            //  Collections.sort(l);
            ans.add(l);
        }

        return ans;

    }

    class Pair<F, S> {
        public F first;
        public S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
