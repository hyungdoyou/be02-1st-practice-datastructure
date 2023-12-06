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

    // 데이터 추가 기능
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

    // 전위 순회
    public void preOrder(Node node) {
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
    // 중위 순회
    public void inOrder(Node node) {
        if (node != null) {

            // 왼쪽
            if (node.left != null) {
                preOrder(node.left);
            }

            // 중간
            System.out.print(node.data + " ");

            // 오른쪽
            if(node.right != null) {
                preOrder(node.right);
            }
        }
    }
    // 후위 순회
    public void postOrder(Node node) {
        if (node != null) {

            // 왼쪽
            if (node.left != null) {
                preOrder(node.left);
            }
            // 오른쪽
            if(node.right != null) {
                preOrder(node.right);
            }

            // 중간
            System.out.print(node.data + " ");
        }
    }

    // 삭제 / 1. 자식 노드가 없는 노드 삭제
    public void removeNo(Integer node) {
        current = root;
        while(true) {
            if(node > current.data) {
                if(current.right.data == node) {
                    current.right = null;
                    break;
                } else {
                    current = current.right;
                }
            }
            if(node < current.data) {
                if(current.left.data == node) {
                    current.left = null;
                    break;
                } else {
                    current = current.left;
                }
            }
        }
    }

    // 삭제 / 2. 자식이 하나인 노드 삭제
    // 삭제하는 노드 대신에 자식 노드로 대체
    public void removeOne(Integer node) {
        current = root;
        while(true) {
            if(node > current.data) {
                if(current.right.data == node) {
                    if(current.right.right != null) {
                        current.right = current.right.right;
                        break;
                    } else if(current.right.left != null) {
                        current.right = current.right.left;
                        break;
                    }
                } else if(current.left.data == node) {
                    if(current.right.right != null) {
                        current.right = current.right.right;
                        break;
                    } else if(current.right.left != null) {
                        current.right = current.right.left;
                        break;
                    }
                } else {
                    current = current.right;
                }
            }
            if(node < current.data) {
                if(current.left.data == node) {
                    if(current.left.right != null) {
                        current.left = current.left.right;
                        break;
                    } else if(current.left.left != null) {
                        current.left = current.left.left;
                        break;
                    }
                } else {
                    current = current.left;
                }
            }
        }
    }

    // 삭제 / 3. 자식이 두개인 노드 삭제
    // 왼쪽을 기준으로 했을때 : 삭제하는 노드 대신에 왼쪽 서브트리에서 가장 큰 노드로 대체
    // 오른쪽을 기준으로 했을때 : 삭제하는 노드 대신에 오른쪽 서브트리에서 가장 작은 노드로 대체
    public void removeTwo(Integer node) {
    }

}
