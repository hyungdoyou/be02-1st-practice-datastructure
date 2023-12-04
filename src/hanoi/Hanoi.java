package hanoi;

public class Hanoi {

    Integer cnt = 0; // 옮깃 횟수
    // 	이동(원반 번호와 from에서 to로 옮길지를 전달받는다.)
    //		원반 번호가 1보다 크면 원반 번호 -1을 from에서 from과 to가 아닌 곳으로 이동
    //		원반 번호를 from에서 to로 옮겼다고 출력
    //		원반 번호가 1보다 크면 원반 번호 -1을 from과 to가 아닌 곳에서 to로 이동
    public void move(Integer number, Integer from, Integer to) {
        if(number > 1) {
            move(number-1, from, 6-from-to);
            this.cnt++;
        }

        System.out.println("["+number+"]번 원반을 "+from+"번 기둥에서 " +to +"번 기둥으로 옮김");

        if(number > 1) {
            move(number-1, 6-from-to, to);
            this.cnt++;
        }
    }
    public void count() {
        this.cnt++;
        System.out.println("총 이동 횟수 : " + this.cnt);
    }
}
