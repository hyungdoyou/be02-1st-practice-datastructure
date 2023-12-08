package heap;

// 개념 설명
// 각 클래스 코드 설명
// 각 회차가 출력이 되게 동작 설명
// 배열 출력 후 트리 구조 출력 까지
// 10개 데이터 랜덤 생성 후 배열에 저장

public class HeapMain {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.arr[0] = 0;
        for(int i=1; i<11; i++) {
            Integer randNum = (int)(Math.random()*100);
            heap.add(randNum);
        }
        for(int i=0; i<11; i++) {
            System.out.print(heap.arr[i] + " ");
        }
    }
}
