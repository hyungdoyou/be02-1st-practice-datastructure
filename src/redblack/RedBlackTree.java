package redblack;

import javax.management.NotificationEmitter;

public class RedBlackTree {
    // 이진 탐색 트리 구현
    // 추가할 데이터가 기존 데이터 보다 크면 오른쪽, 작으면 왼쪽에 추가
    Node root; // 루트 노드
    Node current;  // 현재 노드
    public RedBlackTree() {
        this.root = null;
    }
    // 전위 순회
    public void preOrder() {
        System.out.print("전위 순회 : ");
        this.preOrder(this.root);
        System.out.println();
    }
    public void preOrder(tree.Node node) {
        if (node != null) {

            // 중간
            System.out.print(node.data + " ");
            // 왼쪽
            if (node.left != null) {
                preOrder(node.left);
            }
            // 오른쪽
            if(node.right != null) {
                preOrder(node.right);
            }
        }
    }
    // 데이터 추가 기능
    public void add(Integer data) {
        current = root;
        if(root == null) {
            Node node = new Node(data);
            root = node;
            node.color = 0;  // 최초 루트 노드 생성 시 색깔은 검정이므로 별도 지정
        } else {
            Node node = new Node(data);
            while(current != null) {
                // 만약 추가하려는 data가 current 데이터보다 크다면
                if(data > current.data) {
                    // 만약 이동한 current에 데이터가 없으면
                    if(current.right == null) {
                        // current의 오른쪽에 새로운 node를 추가한다.
                        // 만약 current의 색깔이 빨강이라면
                        if(current.color == 1) {

                        } else {
                            // 그렇지 않으면 그냥 데이터 추가
                            current.right = node;
                            break;
                        }
                        // 그렇지 않다면
                    } else {
                        // current를 오른쪽으로 이동시킨다.
                        current = current.right;
                    }
                }
                // 만약 추가하려는 data가 current 데이터보다 작다면
                else if(data < current.data) {
                    // 만약 이동한 current에 데이터가 없으면
                    if(current.left == null) {
                        // current의 왼쪽에 새로운 node를 추가한다.
                        current.left = node;
                        break;
                        // 그렇지 않다면
                    } else {
                        // current를 왼쪽으로 이동시킨다.
                        current = current.left;
                    }
                }
            }
        }
    }
}
