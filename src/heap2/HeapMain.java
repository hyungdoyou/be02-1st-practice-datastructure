package heap2;

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
        Integer[] numArray = new Integer[heap.arr.length-1];

        heap.add(null);  // 0번 인덱스는 null 값으로 고정

        while(flag) {
            flag = false;
            for(int i=0; i<numArray.length; i++) {
                randNum = (int)(Math.random()*100)+1;
                numArray[i] = randNum;
            }
            for(int i=0; i<numArray.length; i++) {
                for(int j=0; j<i; j++) {
                    if(numArray[i] == numArray[j]) {
                        flag = true;
                    }
                }
            }
        }
        System.out.print("데이터를 삽입한 순서 : ");
        for(int i=1; i<heap.arr.length; i++) {
            System.out.print(numArray[i-1] + " ");
            heap.add(numArray[i-1]); // 중복되지 않은 숫자를 heap 배열에 넣어준다.
        }
        System.out.println();
        heap.printHeap();
        System.out.println();
        heap.sort();
    }
}
