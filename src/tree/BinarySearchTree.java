package tree;

import javax.management.NotificationEmitter;

public class BinarySearchTree {
    // 이진 탐색 트리 구현
    // 추가할 데이터가 기존 데이터 보다 크면 오른쪽, 작으면 왼쪽에 추가
    Node root; // 루트 노드
    Node current;  // 현재 노드
    public BinarySearchTree() {
        this.root = null;
    }

    // 추가 기능
    public void add(Integer data) {
        current = root;
        if(root == null) {
            Node node = new Node(data);
            root = node;
        } else {
            Node node = new Node(data);
            // current가 null 이 아닐때까지 반복한다
            while(current != null) {
                // 만약 추가하려는 data가 current 데이터보다 크다면
                if(data > current.data) {
                    // 만약 이동한 current에 데이터가 없으면
                    if(current.right == null) {
                        // current의 오른쪽에 새로운 node를 추가한다.
                        current.right = node;
                        break;
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
