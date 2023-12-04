package stack;

public class StackMain {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        //stack.isEmpty();
        stack.push(40);
        //stack.isFull();
        //stack.display();

        stack.push(20);
        //stack.display();
        stack.pop();
        stack.display();

        System.out.println();
        stack.push(30);
        stack.push(45);
        stack.push(20);
        stack.push(14);
        stack.display();
        //stack.push(29);
        stack.isFull();
        stack.pop();

        //System.out.println();
        stack.display();
        stack.pop();
        stack.display();
        //stack.isFull();
        //stack.push(20);
    }
}
