package heap;

public class Heap {
    // 힙 정렬 구현
    // 출력 결과 : 1회전 시 마다 배열 결과 출력 및 트리 형태 출력
    // 오름차순 ( 최소힙 트리 ) 또는 내림차순 ( 최대 힙 트리 ) 결정
    // 왼쪽 자식 : 부모 인덱스 * 2 , 오른쪽 자식 : 부모 인덱스 * 2 + 1
    // 삭제한 데이터 : 새로운 인덱스 배열에 삽입
    // 1번 삭제할때마다 회전 수 1증가

    Integer[] arr;  // 최초 데이터를 담을 배열
    Integer[] resultArr;  // 최소 또는 최대힙 정렬을 통해 정렬한 결과를 차례로 담을 배열

    // 배열에 데이터 삽입
    // 최소힙 트리 일 경우 : 부모가 자식보다 작아야된다. (root 데이터 : 가장 작음)
    // 최대힙 트리 일 경우 : 부모가 자식보다 커야된다.   (root 데이터 : 가장 큼)

    // 최소 힙 트리 기준 데이터 삽입
    Integer num;
    public void add(Integer data) {
        arr[0] = null;
        // 만약 배열의 0번 인덱스가 null 이라면
        if(arr[1] == null)  {
            // 0번 인덱스에 새로운 데이터 저장
            arr[1] = data;
        // 그렇지 않으면,
        } else {
            // 데이터를 다음 인덱스에 추가
            for(int i=2; i<arr.length; i++) {
                if(arr[i] == null) {
                    arr[i] = data;
                    this.num = i;
                }
                // 크기 비교 (1번 인덱스 부터 추가한 인덱스 번호까지만 비교)
                while (num == 1){
                    int temp = 0;
                    if(arr[num/2] > arr[num]) {
                        arr[num/2] = temp;
                        arr[num/2] = arr[num];
                        arr[num] = temp;
                    }
                    num = num / 2;
                }
            }
        }
    }

    // 배열에서 데이터 삭제
    public void delete() {
        // 구성이 끝난 상태에서 배열의 1번 인덱스를 출력하여 결과 출력 배열(resultArr) 에 데이터를 삽입하고
        // 1번 인덱스를 배열의 마지막 인덱스로 바꾸고, 마지막 인덱스는 null 로 값 변경
        //

    }

}
