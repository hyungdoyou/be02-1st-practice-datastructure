package heap2;

import org.w3c.dom.ls.LSOutput;

public class Heap {

    Integer[] arr;  // 데이터를 저장할 배열
    Integer[] resultArr;  // 최소힙 정렬을 통해 정렬한 결과를 저장할 배열

    public Heap(Integer length) {
        this.arr = new Integer[length];
        this.resultArr = new Integer[length-1];
    }

    // 최소힙 트리 데이터 삽입 메서드
    // 최소힙 트리 일 경우 : 부모가 자식보다 작아야된다. (root 데이터 : 가장 작음)
    Integer num;  // 데이터를 삽입할 때 인덱스 번호를 저장할 변수
    public void add(Integer data) {
        // 만약 0번 인덱스에 데이터가 없으면
        if (this.arr[0] == null) {
            // 0번 인덱스에 데이터를 삽입한다.(-1) 이값은 힙의 구성을 편하게 하기위한 값으로 건들지 않는다.
            this.arr[0] = data;
        }
        // 그렇지 않으면
        else {
            // 데이터를 다음 인덱스에 추가
            for(int i=1; i<this.arr.length; i++) {
                if (this.arr[i] == null) {
                    this.arr[i] = data;
                    this.num = i;
                    // 크기 비교 (1번 인덱스 부터 추가한 인덱스 번호까지만 비교)
                    while (this.num != 0) {
                        int temp = 0;
                        if (this.arr[num / 2] < this.arr[num]) {
                            temp = this.arr[num / 2];
                            this.arr[num / 2] = this.arr[num];
                            this.arr[num] = temp;
                        }
                        this.num = num / 2;
                    }
                    break;
                }
            }
        }
    }

    // 데이터 정렬 메서드
    public void sort() {
        // 구성이 끝난 상태에서 배열의 1번 인덱스를 출력하여 결과 출력 배열(resultArr) 에 데이터를 삽입하고
        // 1번 인덱스를 배열의 마지막 인덱스로 바꾸고, 마지막 인덱스는 null 로 값 변경
        // 배열의 제일 첫번째 데이터를 결과 배열에 저장한다.
        Integer last = this.arr.length-1;
        Integer temp = 0;
        Integer cnt = 1;

        for(int i=this.resultArr.length-1; i>=0; i--) {
            Integer first = 1;
            // 만약 정렬 배열에 인덱스가 null 이라면
            if(this.resultArr[i] == null) {
                // 해당 인덱스에 arr 배열의 1번째 인덱스 데이터를 삽입한다.
                this.resultArr[i] = this.arr[first];

                // 삽입 후 arr 배열의 1번째 인덱스를 arr 배열의 마지막인덱스로 바꾼다.
                this.arr[first] = this.arr[last];
                // 마지막 인덱스는 null 로 바꾼다.
                this.arr[last] = null;
                // 마지막 인덱스 번호를 1뺀다.
                last = last - 1;
                // 바꾼뒤 자식들과 대소비교를 통해 만약 왼쪽, 오른쪽 자식중에서 제일 작은 자식과 바꾼다.
                // 먼저 왼쪽 자식
                while (true) {
                    if(first*2+1 >= this.arr.length) {
                        break;
                    }
                    if(this.arr[first*2+1] == null && this.arr[first*2] == null) {
                        break;
                    } else if(this.arr[first*2+1] == null && this.arr[first*2] != null) {
                        if(this.arr[first] < this.arr[first*2]) {
                            temp = this.arr[first];
                            this.arr[first] = this.arr[first*2];
                            this.arr[first*2] = temp;
                            break;
                        } else {
                            break;
                        }
                    } else if(this.arr[first*2 + 1] != null && this.arr[first*2] != null) {

                        // 만약 오른쪽 자식 데이터가 왼쪽 자식 데이터보다 크다면
                        if(this.arr[first*2] < this.arr[(first*2) + 1]) {
                            // 만약 1번째 데이터가 오른쪽 자식 데이터보다 작다면 두개를 바꾼다.
                            if(this.arr[first] < this.arr[first*2 + 1]) {
                                temp = this.arr[first];
                                this.arr[first] = this.arr[first*2 + 1];
                                this.arr[first*2 + 1] = temp;
                                first = (first*2 + 1);
                            } else {
                                break;
                            }
                        }
                        // 그렇지 않으면
                        else {
                            // 1번째 데이터와 왼쪽 자식 데이터와 크기를 비교한다.
                            // 만약 1번째 데이터가 왼쪽 자식 데이터보다 작다면 두개를 바꾼다.
                            if(this.arr[first] < this.arr[first*2]) {
                                temp = this.arr[first];
                                this.arr[first] = this.arr[first*2];
                                this.arr[first*2] = temp;
                                first = first*2;
                            } else {
                                break;
                            }
                        }
                    }
                }
                System.out.print(cnt +" 회전 결과 : ");
                for(int j=1; j<this.arr.length; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }
            cnt++;
        }
        System.out.print("최종 정렬 결과 : ");
        for(int k=0; k<this.resultArr.length; k++) {
            System.out.print(this.resultArr[k] + " ");
        }
    }

    // 배열 출력 메서드
    public void printHeap() {
        System.out.print("최초 데이터 삽입이 끝난 결과 : ");
        for(int i=1; i<this.arr.length; i++) {
            System.out.print(this.arr[i] + " ");
        }
    }
}
