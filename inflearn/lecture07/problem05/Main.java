package inflearn.lecture07.problem05;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = null;
        rt = null;
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
        DFS(root);
    }

    private static void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.data + " ");
            DFS(root.lt);
            DFS(root.rt);
        }
    }
}
