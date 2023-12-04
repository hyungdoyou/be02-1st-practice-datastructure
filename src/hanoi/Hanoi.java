package hanoi;

public class Hanoi {

    Integer[] line = {1, 2, 3};
    Integer arr1[];  // 1번 기둥
    Integer arr2[];  // 2번 기둥
    Integer arr3[];  // 3번 기둥
    Integer cnt = 0; // 옮깃 횟수
    // 1번 기둥에 원반 입력받음

    Integer number;
    public void hanoi(Integer number) {
        Integer[] arr1 = new Integer[number];
        for (int i = 0; i < number; i++) {
            arr1[i] = i + 1;
        }
    }
    // 	이동(원반 번호와 from에서 to로 옮길지를 전달받는다.)
    //		원반 번호가 1보다 크면 원반 번호 -1을 from에서 from과 to가 아닌 곳으로 이동
    //		원반 번호를 from에서 to로 옮겼다고 출력
    //		원반 번호가 1보다 크면 원반 번호 -1을 from과 to가 아닌 곳에서 to로 이동
    public void move(Integer number, Integer from, Integer to) {
        if(number > 1) {
            System.out.println("원반["+number+"]을"+from+"기둥에서 " +to +" 기둥으로 옮김");
        }
        move(number-1, 1, 3);

    }

}
