package list;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertFirst(10);
        linkedList.insertFirst(20);
        linkedList.insertFirst(30);
        linkedList.insertFirst(40);
        linkedList.display();

        linkedList.insertLast(50);
        linkedList.insertLast(60);
        linkedList.display();

        linkedList.insertIndex(70, 3);
        linkedList.display();

        linkedList.removeIndex(2);
        linkedList.display();

        linkedList.removeFirst();
        linkedList.display();

        linkedList.removeLast();
        linkedList.display();
    }
}
