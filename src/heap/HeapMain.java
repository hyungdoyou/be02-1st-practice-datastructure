package heap;

// 개념 설명
// 각 클래스 코드 설명
// 각 회차가 출력이 되게 동작 설명
// 배열 출력 후 트리 구조 출력 까지
// 10개 데이터 랜덤 생성 후 배열에 저장

public class HeapMain {
    public static void main(String[] args) {
        Integer randNum;
        Boolean flag = true;
        Heap heap = new Heap(11);

        // 0번 인덱스에 null을 넣어준다.
        heap.add(null);

        while(flag) {
            for(int i=1; i<heap.arr.length; i++) {
                randNum = (int)(Math.random()*100)+1;
                heap.add(randNum);

                for(int j=1; j<i; j++) {
                    if(heap.arr[i] == heap.arr[j]) {
                        heap.arr[j] = (int)(Math.random()*100)+1;
                    }
                }
            }
            for(int i=1; i<heap.arr.length; i++) {
                for(int j=1; j<i; j++) {
                    if(heap.arr[i] != heap.arr[j]) {
                        flag= false;
                    }
                }
            }
        }
        // 최초 모든 데이터가 들어간 결과
        heap.printHeap();

        System.out.println();

        // 정렬된 결과
        heap.sort();
    }
}
