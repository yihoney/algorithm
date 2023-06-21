package inflearn.lecture07.problem10;

import java.util.*;

class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int val) {
        this.data = val;
        this.lt = null;
        this.rt = null;
    }
}

public class Main {
    Node root;

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));
    }

    public int BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curNode = queue.poll();
                if (Objects.isNull(curNode.lt) && Objects.isNull(curNode.rt)) {
                    return level;
                }
                if (Objects.nonNull(curNode.lt)) {
                    queue.add(curNode.lt);
                }
                if (Objects.nonNull(curNode.rt)) {
                    queue.add(curNode.rt);
                }
            }
            level++;
        }
        return 0;
    }
}