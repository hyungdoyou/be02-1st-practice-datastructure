package queue;

public class Queue {
    private Integer[] queue;
    private Integer front;
    private Integer rear;
    private Integer num=0;

    public Queue(Integer size) {
        this.queue = new Integer[size];
        this.front = 0;
        this.rear = 0;
    }

    // 큐가 비어있는지 확인
    Boolean isEmpty() {
        if(this.num == 0) {
            return true;
        } else {
            return false;
        }
    }
    // 큐가 가득찼는지 확인
    Boolean isFull() {
        if(this.num == this.queue.length) {
            return true;
        } else {
            return false;
        }
    }
    // 데이터를 저장하는 연산
    public void enQueue(Integer data) {
        if(isFull() == true) {
            System.out.println("큐가 가득찼습니다.");
        } else if (this.rear == this.queue.length) {
            this.rear = 0;
            this.queue[this.rear] = data;
            this.rear = this.rear + 1;
            this.num = this.num + 1;
        } else  {
            this.queue[this.rear] = data;
            this.rear = this.rear + 1;
            this.num = this.num + 1;
        }

    }

    // 데이터를 삭제하는 연산
    public void deQueue() {
        if(isEmpty() == true) {
            System.out.println("큐가 비어있습니다.");
        } else if(this.front == this.queue.length){
                this.front = 0;
                Integer removeNum = this.queue[this.front];
                this.queue[this.front] = null;
                this.front = this.front + 1;
                this.num = this.num - 1;
            } else {
                Integer removeNum = this.queue[this.front];
                this.queue[this.front] = null;
                this.front = this.front + 1;
                this.num = this.num - 1;
            }
    }

    public void display() {
        for(int i=0; i<this.queue.length; i++) {
            if(this.queue[i] != null) {
                System.out.print("[" + this.queue[i] + "]");
            } else {
                System.out.print("[null]");
            }
            System.out.print(" ");
        }
        System.out.print("front : " + this.front + " rear : " + this.rear + " num : " + this.num);

        System.out.println();
    }
}
