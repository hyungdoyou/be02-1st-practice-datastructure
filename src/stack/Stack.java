package stack;

public class Stack {
    private int size;  // 스택의 크기를 지정
    private Integer[] stack;   // null 값을 저장할 수 있는 Wrapper 클래스
    public Stack(int size) {
        this.size = size;
        stack = new Integer[size];   // 입력받은 size 크기의 stack 배열 객체를 생성
    }
    private int top = -1;  // 숫자를 어디까지 저장했는지 가리키는 변수 top 생성

    boolean flag;
    // 스택이 비어있는지 확인 (비어있으면 true, 그렇지 않으면 false를 반환)
    boolean isEmpty() {
        if(this.top == -1) {
            flag = true;
            System.out.println("스택이 비어있습니다.");
        } else {
            flag = false;
            System.out.println("스택이 비어있지 않습니다.");
        }
        return flag;
    }

    // 스택이 꽉차 있는지 확인
    boolean isFull() {
        if(this.top == this.size-1) {
            flag = true;
            System.out.println("스택이 꽉차 있습니다.");
        } else {
            flag = false;
            System.out.println("스택이 꽉차 있지 않습니다.");
        }
        return flag;
    }

    // 제일 마지막에 저장된 값 확인 및 반환  => stack[top]
    int peek() {
        return stack[this.top];
    }

    // 데이터를 저장하는 연산 (push)
    // 스택이 가득차 있지 않으면 = top을 1증가시키고, 해당 인덱스에 데이터 저장
    public void push(int data) {
        if(this.top != size-1) {
            this.top = this.top + 1;
            stack[this.top] = data;
        }
    }
    // 데이터를 삭제하는 연산 (pop)
    // top 인덱스 번호의 값을 꺼내고, top 인덱스 번호의 배열에 값을 비워주고(null), top을 1감소시킨다.
    int removeNum;
    int pop() {
        if(this.top != -1) {
            stack[this.top] = removeNum;
            stack[this.top] = null;
            this.top = top - 1;
        }
        return removeNum;
    }
    public void display() {
        for(int i=0; i<this.size; i++) {
            if(stack[i] != null) {
                System.out.print("[" + stack[i] + "]");
            } else {
                System.out.print("[null]");
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
