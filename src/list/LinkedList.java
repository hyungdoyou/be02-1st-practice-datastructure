package list;

public class LinkedList {
    // head : 맨 처음 노드
    Node head;
    Node current;
    // 생성자
    public LinkedList() {
        this.current = null;
        this.head = null;
    }

    // (1) insertFirst : 데이터를 맨처음에 추가하는 기능
    public void insertFirst(Integer data) {
        if(this.head == null) {
            Node node1 = new Node(data, null);
            this.head = node1;
        } else {
            Node node1 = new Node(data, this.head);
            this.head = node1;

        }
    }

    // (2) insertLast : 데이터를 마지막에 추가하는 기능
    public void insertLast(Integer data) {
        current = head;
        if(current == null) {
            this.insertFirst(data);
        } else {
            while (true) {
                if (current.next == null) {
                    Node node2 = new Node(data, null);
                    current.next = node2;
                    current = current.next;
                    break;
                } else {
                    current = current.next;
                }
            }
        }
    }

    // (3) insertIndex : 데이터를 원하는 순서에 추가하는 기능
    public void insertIndex(Integer data, Integer index) {
        current = head;
        for(int i=0; i<index-2; i++) {
            current = current.next;
        }
        Node node3 = new Node(data, current.next);
        current.next = node3;
        node3.next = current.next.next;
    }

    // 맨 처음 노드를 삭제하는 기능
    public void removeFirst() {
        if(head != null) {
            head = head.next;
        }
    }

    // 맨 마지막 노드를 삭제하는 기능
    public void removeLast() {
        if(head != null) {
            current = head;
            while(true) {
                if(current.next.next == null) {
                    current.next = null;
                    break;
                }
                current = current.next;
            }
        }
    }

    // 원하는 순서의 노드를 삭제하는 기능
    public void removeIndex(Integer index) {
        if(head != null) {
            current = head;
            for(int i=0; i<index-2; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    // 출력
    public void display() {
        current = head;
        while (current != null) {
            System.out.print(current.data);
            if(current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
