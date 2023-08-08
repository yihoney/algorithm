import java.util.*;
import java.io.*;

/**
 * 
 * 데이터, 왼쪽 자식 노드, 오른쪽 자식 노드를 갖는 노드 클래스를 생성
 * 입력 받는 값마다 데이터 비교를 해 알맞은 노드의 자식 노드에 삽입하는 과정 수행
 * 
 * DFS로 전위순회, 중위순회, 후위순회 구현
 * - 전위순회: 뿌리노드 -> 왼쪽 자식노드 -> 오른쪽 자식노드
 * - 중위순회: 왼쪽 자식노드 -> 뿌리노드 -> 오른쪽 자식노드
 * - 후위순회: 왼쪽 자식노드 -> 오른쪽 자식노드 -> 뿌리노드
 * 
 * @author 이하늬
 */

class Node {
    char data; // 데이터
    Node lt; // 왼쪽 자식 노드
    Node rt; // 오른쪽 자식 노드

    public Node(String data) {
        this.data = data.charAt(0);
        this.lt = null;
        this.rt = null;
    }
}

public class Main {
    static Node root;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 이진 트리의 노드 개수
        StringTokenizer st;

        // 루트 노드 생성
        root = new Node("A");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            Node node = new Node(st.nextToken());
            String ltData = st.nextToken();
            // 받은 데이터가 "."이면, Null을, "."이 아니면 해당 데이터를 갖는 노드를 생성해 루트 노드의 왼쪽 자식 노드에 저장
            node.lt = (ltData.equals(".") ? null : new Node(ltData));
            String rtData = st.nextToken();
            // 받은 데이터가 "."이면, Null을, "."이 아니면 해당 데이터를 갖는 노드를 생성해 루트 노드의 오른쪽 자식 노드에 저장
            node.rt = (rtData.equals(".") ? null : new Node(rtData));

            // 노드를 매칭해 삽입하는 과정 수행

            matchNode(node, root);
        }

        preOrder(root); // 전위순회
        sb.append("\n");
        inOrder(root); // 중위순회
        sb.append("\n");
        postOrder(root); // 후위순회

        System.out.println(sb);
    }

    static void matchNode(Node node, Node baseNode) {

        if (Objects.isNull(node)) { // 탐색할 노드가 null이면 종료
            return;
        }

        if (baseNode.data == node.data) { // 기준이 되는 루트 노드의 데이터와 새로 받은 노드의 데이터가 같다면 같은 노드
            // 자식 노드들 저장
            baseNode.lt = node.lt;
            baseNode.rt = node.rt;
            return;
        }

        // 기준이 되는 루트 노드의 데이터와 새로 받은 노드의 데이터가 같지 않다면
        if (Objects.nonNull(baseNode.lt)) {
            matchNode(node, baseNode.lt); // 기준이 되는 루트 왼쪽 자식 노드와 비교 수행
        }
        if (Objects.nonNull(baseNode.rt)) {
            matchNode(node, baseNode.rt); // 기준이 되는 루트 오른쪽 자식 노드와 비교 수행
        }
    }

    private static void preOrder(Node node) {
        if (Objects.isNull(node)) { // 탐색할 노드가 Null이라면
            return; // 순회 종료
        }

        sb.append(node.data);
        preOrder(node.lt);
        preOrder(node.rt);
    }

    private static void inOrder(Node node) {
        if (Objects.isNull(node)) { // 탐색할 노드가 Null이라면
            return; // 순회 종료
        }

        inOrder(node.lt);
        sb.append(node.data);
        inOrder(node.rt);
    }

    private static void postOrder(Node node) {
        if (Objects.isNull(node)) { // 탐색할 노드가 Null이라면
            return; // 순회 종료
        }

        postOrder(node.lt);
        postOrder(node.rt);
        sb.append(node.data);
    }
}
