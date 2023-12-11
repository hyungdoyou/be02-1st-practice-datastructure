package heap2;

import org.w3c.dom.ls.LSOutput;

public class Heap {

    Integer[] arr;  // 최초 데이터를 저장할 배열 생성;
    Integer[] resultArr;  // 최대힙 정렬을 통해 정렬한 결과를 저장할 배열 생성;

    public Heap(Integer length) {
        // 생성한 두개의 배열 초기화
        // 최초 데이터를 저장할 배열의 크기가 length 라면, 최종 정렬한 결과를 저장할 배열의 크기는 length-1
        // Why? 최초 데이터를 저장할 배열의 0번 인덱스는 활용하지 않기 위해 데이터를 1개 더 추가해줬기 때문
        this.arr = new Integer[length];
        this.resultArr = new Integer[length-1];
    }

    // 최대힙 트리 데이터 삽입 메서드
    Integer num;  // 데이터를 삽입할 때 인덱스 번호를 저장할 변수 생성
    public void add(Integer data) {
        // 만약 0번 인덱스에 데이터가 null 이 아니라면(0번 인덱스에 null 을 넣어줄 예정)
        if (this.arr[0] != null) {
            // 0번 인덱스에 데이터를 삽입한다. 이값은 힙의 구성을 편하게 하기 위한 값으로 건들지 않는다.
            this.arr[0] = data;
        }
        // 그렇지 않으면
        else {
            // 데이터를 1번 인덱스부터 배열의 크기만큼 반복
            for(int i=1; i<this.arr.length; i++) {
                // 만약 해당 인덱스에 데이터가 없다면
                if (this.arr[i] == null) {
                    // 해당 인덱스에 데이터를 추가
                    this.arr[i] = data;
                    // 이때  num 변수에 인덱스 번호를 저장
                    this.num = i;
                    // 새로 추가한 인덱스를 2로 나눈 몫이 0보다 크면 반복한다.
                    while (this.num/2 > 0) {
                        int temp = 0;  // 데이터를 교환해주기 위해 임시로 데이터를 저장해둘 temp 변수 생성

                        // 만약 새로 추가한 데이터가 부모 데이터 보다 크다면 부모 데이터와 서로 바꾼다.
                        if (this.arr[num / 2] < this.arr[num]) {
                            temp = this.arr[num / 2];
                            this.arr[num / 2] = this.arr[num];
                            this.arr[num] = temp;
                        }
                        this.num = num / 2;
                    }
                    // 데이터 추가가 끝났으면 반복문을 탈출한다.
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
        Integer last = this.arr.length-1;  // 배열의 마지막 인덱스를 저장할 last 변수 생성
        Integer temp = 0;                  // 부모와 값을 비교할 때 값을 바꿔주기 위해 임시로 저장해 둘 temp 변수 생성
        Integer cnt = 1;                   // 회전 수를 출력하기 위한 cnt 변수 생성

        // i가 정렬 배열의 마지막 인덱스부터 0까지 1씩 감소하며 아래의 반복문을 반복한다.
        for(int i=this.resultArr.length-1; i>=0; i--) {
            // 배열의 첫번째 인덱스를 1로 고정시킨다.
            Integer first = 1;
            // 만약 정렬 배열에 인덱스가 null 이라면
            if(this.resultArr[i] == null) {
                // 해당 인덱스에 arr 배열의 1번째 인덱스 데이터를 삽입한다.
                this.resultArr[i] = this.arr[first];

                // 삽입 후 arr 배열의 1번째 인덱스를 arr 배열의 마지막인덱스로 바꾼다.
                this.arr[first] = this.arr[last];
                // arr 배열의 마지막 인덱스는 null 로 바꾼다.
                this.arr[last] = null;
                // arr 배열의 마지막 인덱스 번호를 1뺀다.
                last = last - 1;

                while (true) {
                    // 만약 인덱스 값이 arr 배열의 크기보다 커지면 반복문을 탈출한다.
                    if(first*2+1 >= this.arr.length) {
                        break;
                    }
                    // 만약 왼쪽 자식과 오른쪽 자식 모두 null 이면 비교할 값이 없기 때문에 반복문을 탈출한다.
                    if(this.arr[first*2+1] == null && this.arr[first*2] == null) {
                        break;
                    // 그렇지 않고 만약 왼쪽 자식은 null 이 아니고 오른쪽 자식이 null 이라면(부모와 왼쪽 자식만 비교하면 된다)
                    } else if(this.arr[first*2+1] == null && this.arr[first*2] != null) {
                        // 만약 왼쪽 자식이 부모 자식보다 크다면 서로 바꿔준다.
                        if(this.arr[first] < this.arr[first*2]) {
                            temp = this.arr[first];
                            this.arr[first] = this.arr[first*2];
                            this.arr[first*2] = temp;
                            // 바꿔준뒤 반복문을 탈출한다.
                            break;
                        // 만약 부모가 왼쪽 자식보다 커서 바꿀 필요가 없으면 반복문을 탈출한다.
                        } else {
                            break;
                        }
                    // 그렇지 않고 만약 왼쪽 자식과 오른쪽 자식 모두 null 이 아니라면
                    } else if(this.arr[first*2 + 1] != null && this.arr[first*2] != null) {

                        // 만약 오른쪽 자식이 왼쪽 자식 보다 크다면
                        if(this.arr[first*2] < this.arr[(first*2) + 1]) {
                            // 만약 root 가 오른쪽 자식 보다 작다면 서로 바꿔준다.
                            if(this.arr[first] < this.arr[first*2 + 1]) {
                                temp = this.arr[first];
                                this.arr[first] = this.arr[first*2 + 1];
                                this.arr[first*2 + 1] = temp;
                                first = (first*2 + 1);
                            // 그렇지 않으면 반복문을 탈출한다.
                            } else {
                                break;
                            }
                        }
                        // 그렇지 않으면
                        else {
                            // 1번째 데이터와 왼쪽 자식 데이터와 크기를 비교한다.
                            // 만약 root 가 왼쪽 자식 보다 작다면 서로 바꿔준다.
                            if(this.arr[first] < this.arr[first*2]) {
                                temp = this.arr[first];
                                this.arr[first] = this.arr[first*2];
                                this.arr[first*2] = temp;
                                first = first*2;
                            // 그렇지 않으면 반복문을 탈출한다.
                            } else {
                                break;
                            }
                        }
                    }
                }
                // 회전 할때마다 배열에 남아있는 데이터를 출력한다.
                System.out.print(cnt +" 회전 결과 : ");
                for(int j=1; j<this.arr.length; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }
            // 회전수를 1씩 증가한다.
            cnt++;
        }
        // 최종적으로 정렬된 결과를 출력한다.
        System.out.print("최종 정렬 결과 : ");
        for(int k=0; k<this.resultArr.length; k++) {
            System.out.print(this.resultArr[k] + " ");
        }
    }

    // 최대힙 출력 메서드
    public void printHeap() {
        System.out.print("모든 데이터 삽입이 끝난 결과 : ");
        for(int i=1; i<this.arr.length; i++) {
            System.out.print(this.arr[i] + " ");
        }
    }
}
