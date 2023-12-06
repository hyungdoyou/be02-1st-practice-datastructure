package redblack;

public class RedBlackTree {
    // 레드블랙 트리 구현
    // 추가할 데이터가 기존 데이터 보다 크면 오른쪽, 작으면 왼쪽에 추가
    Node root; // 루트 노드
    Node temp;
    Node current;  // 현재 노드

    public RedBlackTree() {
        this.current = null;
        this.root = null;
    }

    // 데이터 추가 기능
    public void add(Integer data) {
        // 만약 root 노드가 없으면 root 노드를 추가해준다.
        if (root == null) {
            root = new Node(data, null);
            root.color = 0;
            return;
        }
        Node current = root;
        while(true){
            if(current.data < data){
                if(current.right == null){
                    current.right = new Node(data,current);
                    break;
                }
                current = current.right;
            }
            else{
                if(current.left == null) {
                    current.left = new Node(data, current);
                    break;
                }
                current = current.left;
            }
            isComplete(current);   //  데이터 추가하고 레드블랙함수 규칙대로 바꿔줌
        }
    }

    // 추가한 노드(current) 를 인수로 받아서 규칙을 만족토록 바꿔준다.
    public void isComplete(Node current) {
        while (true) {
            // 만약에 추가한 노드(current) 와 부모의 노드의 색깔이 같다면
            if(current.color == current.parent.color) {
                // 만약에 삼촌의 색깔이 빨간색이라면 : recoloring 실시
                if(current.parent.parent.color == 1) {
                    // 부모와 삼촌의 색깔을 검은색으로 바꾸고
                    current.parent.color = 0;
                    current.parent.parent.color = 0;
                    // 만약 조부모가 root 라면 검정색
                    if(current.parent.parent == root) {
                        current.parent.parent.color = 0;
                    // 그렇지 않으면 빨간색으로 바꾼다.
                    } else {
                        current.parent.parent.color = 1;
                    }
                }
                // 그렇지 않고 만약에 삼촌이 null 이라면 : restructuring 실시
                else if (current.parent.parent.left == null) {
                    // 만약 새로 추가한 노드(current) 가 부모노드의 오른쪽 자식인 경우
                    // 그렇지 않고 만약에 부모노드의 왼쪽 자식인 경우

                }
                // 그렇지 않고 만약에 삼촌의 색깔이 검정색 이라면 : restructuring 실시
                else if (current.parent.parent.left.color == 0) {
                    // 만약 새로 추가한 노드(current) 가 부모노드의 오른쪽 자식인 경우
                    if(current == current.parent.right) {

                    }

                    // 그렇지 않고 만약에 부모노드의 왼쪽 자식인 경우
                    if(current == current.parent.left) {
                        // 부모노드를 검은색
                        // 조부모 노드를 빨간색으로 칠한다.
                        current.parent.color = 0;
                        current.parent.parent.color = 1;

                        // 그다음 조부모 노드를 오른쪽으로 회전시킨다.

                    }

                }
            }
        }
    }
}