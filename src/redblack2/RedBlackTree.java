package redblack2;

import redblack2.Node;

public class RedBlackTree {
    Node root; // root 노드 변수를 생성한다.

    public RedBlackTree() {
        //this.root = root;
    }

    // 이진탐색 트리 의거 데이터를 추가하는 기능 add 메서드
    public void add(Integer data){
        // 만약 root가 null 이라면
        if(root == null){
            // 새로 추가하는 데이터를 root 노드의 데이터로 넣어준다. 이때 root 노드의 부모는 null 이다.
            root = new Node(data,null);

            // root 노드의 색깔은 검정색이므로 검정색으로 설정해준다.
            root.color = false;

            // 다시 메서드의 처음으로 돌아간다.
            return;
        }

        // 새로운 "node" 라는 이름의 노드 객체 변수를 생성 하고, "node" 변수에 "root" 를 저장해준다.
        Node node = root;

        // 무한 반복을 실시한다.
        while(true){
            // 만약 기존에 생성한 "node" 변수의 데이터가 새로 삽입하는 노드의 데이터보다 작으면
            if(node.data < data){
                // 만약 기존에 생성한 "node" 변수의 오른쪽 노드에 데이터(값) 이 없다면(null 이라면)
                if(node.right.data == null){
                    // 기존 "node"의 오른쪽에 새로운 노드를 생성하여 연결해준다.
                    node.right = new Node(data,node);
                    // 기준이 되는 "node"의 위치를 기준 노드의 오른쪽 노드로 이동하여 기준 노드를 변경한다.
                    node = node.right;
                    // 반복문을 종료시킨다(왜? 새로운 노드를 생성하였기 때문이다.)
                    break;
                }
                // 만약 기준 노드의 오른쪽이 null이 아닐때는 기준 노드의 위치를 오른쪽 노드로 이동시켜준다.
                // 그리고 나서 오른쪽으로 이동한 노드의 위치에서 다시 반복문을 처음부터 시작한다.
                node = node.right;
            }
            // 그렇지 않고 만약에 기존에 생성한 "node" 변수의 데이터가 새로 삽입하는 노드의 데이터보다 크다면
            else{
                // 만약 기존에 생성한 "node" 변수의 왼쪽 노드에 데이터(값) 이 없다면(null 이라면)
                if(node.left.data == null) {
                    // 기존 "node"의 왼쪽에 새로운 노드를 생성하여 연결해준다.
                    node.left = new Node(data,node);
                    // 기준이 되는 "node"의 위치를 기준 노드의 왼쪽 노드로 이동하여 기준 노드를 변경한다.
                    node = node.left;
                    // 반복문을 종료시킨다(왜? 새로운 노드를 생성하였기 때문이다.)
                    break;
                }
                // 만약 기준 노드의 왼쪽이 null이 아닐때는 기준 노드의 위치를 왼쪽 노드로 이동시켜준다.
                // 그리고 나서 왼쪽으로 이동한 노드의 위치에서 다시 반복문을 처음부터 시작한다.
                node = node.left;
            }
        }
        // 만약 기준으로 잡은 "node" 의 부모의 색깔이 검정색이라면 반복문을 탈출한다.
        // Why ? -> 규칙을 만족하는지 더이상 확인할 필요가 없다. 더블레드 조건이 발생할 일이 없기 때문에
        if(!node.parent.color) return;

        // 위에서 이진 탐색 트리 의거 데이터의 삽입이 이뤄졌다.
        // 이것을 레드블랙 트리 규칙을 만족하는지 아래의 반복문으로 점검해주겠다.

        // 레드블랙트리의 규칙을 만족할때까지 무한 반복한다.
        while(!isCompelet() ){
            // 만약 기준 node의 조부모가 null 이라면 반복문을 탈출한다. 왜? 조부모가 null이라는것은 root이기 때문에
            if(node.parent.parent == null) break;

            // 삼촌 노드 변수를 새로 생성하는데 삼촌 노드를 "기준 노드의 조부모의 오른쪽" 이라고 저장할 때,
            Node uncle = node.parent.parent.right;
            // 만약 삼촌이 기준 노드의 부모와 같다면 삼촌은 조부모의 오른쪽이 아니기 때문에,
            if(uncle == node.parent){
                // 삼촌 노드를 "기준 노드의 조부모의 왼쪽" 으로 다시 저장해준다.
                uncle = uncle.parent.left;
            }
            // 만약 삼촌 노드의 색깔이 참이라면(빨간색 이라면)
            if(uncle.color){
                // recoloring() 메서드를 실시하는데 실시한 뒤 반환된 "node"를 "node 변수" 에 저장해준다.
                node = recoloring(node);

                // root 노드의 색깔은 검정색으로 저장해준다.
                // Why? recoloring 과정에서 만약, root 노드까지 올라갔을때 root 노드의 색깔을 빨간색으로 바꾸기 때문에
                root.color = false;
            }
            // 그렇지 않고 만약에 삼촌 노드의 색깔이 거짓이라면(검정색 이라면)
            else{
                // restructruing() 메서드를 실시하는데 실시한 뒤 반환된 "node"를 "node 변수" 에 저장해준다.
                node = restructuring(node);
            }

            // 만약 위의 조건문을 통해 나온 "node 변수" 의 부모가 null 이라면 반복문을 탈출한다.
            if(node.parent == null) break;
        }
    }

    // recoloring 기능의 메서드를 생성한다.
    private Node recoloring(Node node) {
        // 삼촌 노드를 기준 노드의 조부모의 오른쪽이라고 가정하여 저장할 때,
        Node uncle = node.parent.parent.right;

        // 만약 삼촌 노드가 기준 노드의 부모와 같다면
        // 삼촌 노드를 "조부모의 왼쪽" 으로 다시 저장해준다.
        if(uncle == node.parent) {
            uncle = uncle.parent.left;
        }

        // 삼촌 노드의 색깔은 검정색으로 바꾸고,
        uncle.color = false;

        // 기준 노드의 부모의 색깔을 검정색으로 바꾸고,
        node.parent.color = false;

        // 기준 노드의 조부모의 색깔을 빨간색으로 바꿔준다.
        node.parent.parent.color = true;

        // 이때 root의 색깔을 건들 수 있으므로 root 의 색깔은 검정색으로 설정해준다.
        root.color = false;

        // 기준 노드의 조부모를 node 매개변수로 반환 시켜준다.
        // 왜? 기준 노드의 조부모가 빨간색으로 바뀌면서 또다시 더블레드 문제가 발생할 수 있기 때문에
        return node.parent.parent;
    }

    // restructuring 기능 구현 메서드 생성
    private Node restructuring(Node node) {
        Node big;     // 가장 큰 값의 노드 변수를 "big" 으로 생성
        Node middle;  // 가장 중간 값의 노드 변수를 "middle" 으로 생성
        Node small;   // 가장 가장 작은 값의 노드 변수를 "small" 으로 생성

        // 만약 매개변수로 들어온 "node" 가 "node"의 부모의 왼쪽에 있다면
        if(node == node.parent.left){
            // 만약 "node" 의 부모가 "node" 의 조부모의 왼쪽에 있다면 (왼쪽으로 일직선 형태)
            if(node.parent == node.parent.parent.left){
                // "big" 노드는 "node" 의 조부모가 되고
                big = node.parent.parent;
                // "middle" 노드는 "node" 의 부모가 되고
                middle = node.parent;
                // "small" 노드는 "node" 가 된다.
                small = node;
            }
            // 그렇지 않고 만약에, "node"의 부모가 "node"의 조부모의 오른쪽에 잇다면 (오른쪽으로 나오다가 왼쪽으로 꺾이는 형태)
            else{
                // "big" 노드는 "node" 의 부모가 되고
                big = node.parent;
                // "middle" 노드는 "node" 가 되고
                middle = node;
                // "small" 노드는 "node"의 조부모가 된다.
                small = node.parent.parent;
            }
        }
        // 그렇지 않고 만약 매개변수로 들어온 "node" 가 "node"의 부모의 오른쪽에 있다면
        else{
            // 만약 "node" 의 부모가 "node" 의 조부모의 왼쪽에 있다면 (왼쪽으로 나오다가 오른쪽으로 꺾이는 형태)
            if(node.parent == node.parent.parent.left){
                // "big" 노드는 "node" 의 조부모가 되고
                big = node.parent.parent;
                // "middle" 노드는 "node" 가 되고
                middle = node;
                // "small" 노드는 "node"의 부모가 된다.
                small = node.parent;
            }
            // 그렇지 않고 만약에 "node" 의 부모가 "node" 의 조부모의 오른쪽에 있다면 (오른쪽으로 일직선 형태)
            else{
                // "big" 노드는 "노드의 조부모가 되고
                big = node;
                // "middle" 노드는 "node" 의 부모가 되고
                middle = node.parent;
                // "small" 노드는 "node"의 조부모가 된다.
                small = node.parent.parent;
            }
        }
        // 여기까지해서 해서 "big", "middle", "small" 노드가 정해졌다.

        // 만약 "node" 의 조부모의 부모가 null 이라면
        if(node.parent.parent.parent == null) {
            // root를 "middle"로 저장해주고
            this.root = middle;

        // 그렇지 않고 만약 "node"의 조부모의 부모가 null 이 아니라면
        } else {
            // 만약, "node"의 조부모가, 조부모의 부모의 왼쪽 노드라면
            if(node.parent.parent == node.parent.parent.parent.left) {
                // "node"의 조부모의 왼쪽 노드로 "middle" 을 연결해주고,
                node.parent.parent.parent.left = middle;
            // 그렇지 않으면
            } else {
                // "node"의 조부모의 오른쪽 노드로 "middle" 을 연결해준다.
                node.parent.parent.parent.right = middle;
            }
        }

        // "middle" 노드의 부모는 기존 "node"의 조부모의 부모로 저장한다.
        middle.parent = node.parent.parent.parent;

        // 만약, "middle" 노드의 부모가 null 이라면 middle이 root라는게 되므로 root에 middel을 설정해준다.
        if(middle.parent == null) this.root = middle;

        // 만약, "small" 노드가 "middle" 노드의 왼쪽이 아니라면
        if(small != middle.left){
            // "middle" 노드의 왼쪽의 부모를 "small"로 저장하고
            middle.left.parent = small;
            // "small" 노드의 오른쪽을 "middle" 노드의 왼쪽으로 저장하고
            small.right = middle.left;
            // "middle" 노드의 왼쪽을 "small" 노드로 저장하고
            middle.left = small;
            // "small" 노드의 부모를 "middle" 노드로 저장한다.
            small.parent = middle;
        }
        // 만약, "big" 노드가 "middle" 노드의 오른쪽이 아니라면
        if(big != middle.right){
            // "middle" 노드의 오른쪽의 부모를 "big"으로 저장하고

            middle.right.parent = big;
            // "big" 노드의 왼쪽을 "middle" 노드의 오른쪽으로 저장하고
            big.left = middle.right;
            // "middle" 노드의 오른쪽을 "big" 노드로 저장하고

            middle.right = big;
            // "big" 노드의 부모를 "middle" 노드로 저장한다.
            big.parent = middle;
        }

        // "middle" 노드의 색깔은 검정색으로 저장하고
        middle.color = false;
        // "middle" 노드의 왼쪽과 오른쪽 노드의 색깔은 빨간색으로 저장한다.
        middle.left.color = true;
        middle.right.color =true;

        // "middle" 노드를 반환한다.
        return middle;
    }
    private boolean isCompelet() {

        return this.findDoubleRedBypreOrder();
    }

    private Boolean findDoubleRedBypreOrder() {
        Node node = this.root;
        Boolean result = false;
        findDoubleRedBypreOrder(node.left,result);
        findDoubleRedBypreOrder(node.right,result);
        return result;
    }
    private void findDoubleRedBypreOrder(Node node,Boolean isDoubleRed) {
        if(node.data == null) return;
        if(node.color){
            if(node.left.color) {
                isDoubleRed=true;
                return ;
            }
            if(node.right.color) {
                isDoubleRed=true;
                return ;
            }
        }
        findDoubleRedBypreOrder(node.left,isDoubleRed);
        findDoubleRedBypreOrder(node.right,isDoubleRed);
    }
}