package hanoi;

import java.util.Scanner;

public class HanoiMain {
    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();

        Scanner sc = new Scanner(System.in);
        System.out.print("몇개의 원반을 만들것인지 입력하시오 : ");
        Integer num = sc.nextInt();

        System.out.print("몇번 기둥에서 시작하는지 입력하시오 : ");
        Integer from = sc.nextInt();

        System.out.print("몇번 기둥으로 이동시킬 것인지 입력하시오 : ");
        Integer to = sc.nextInt();

        hanoi.move(num,from,to);
        hanoi.count();
    }
}
