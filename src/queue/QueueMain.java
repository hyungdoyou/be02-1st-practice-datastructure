package queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue(3);


        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.display();

        queue.enQueue(40);

        queue.deQueue();
        queue.display();

        queue.deQueue();
        queue.display();

        queue.deQueue();
        queue.display();

        queue.enQueue(40);
        queue.display();

        queue.enQueue(50);
        queue.display();

        queue.enQueue(60);
        queue.display();

        queue.deQueue();
        queue.display();

        queue.enQueue(70);
        queue.display();

        queue.enQueue(80);

        queue.deQueue();
        queue.display();

        queue.deQueue();
        queue.display();

        queue.deQueue();
        queue.display();

        queue.enQueue(80);
        queue.display();

        queue.enQueue(90);
        queue.display();

        queue.enQueue(100);
        queue.display();

        queue.enQueue(110);
        queue.deQueue();
        queue.display();
    }
}
