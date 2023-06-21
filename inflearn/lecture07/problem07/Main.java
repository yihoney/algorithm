package inflearn.lecture07.problem07;

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
    static Node root;

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        BFS(root);
    }

    private static void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(level + " : ");
            for (int i = 0; i < len; i++) {
                Node currentNode = queue.poll();
                System.out.print(currentNode.data + " ");
                if (Objects.nonNull(currentNode.lt)) {
                    queue.add(currentNode.lt);
                }
                if (Objects.nonNull(currentNode.rt)) {
                    queue.add(currentNode.rt);
                }
            }
            level++;
            System.out.println();
        }
    }
}
