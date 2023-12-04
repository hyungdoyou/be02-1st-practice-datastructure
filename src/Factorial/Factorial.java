package Factorial;

public class Factorial {
    // 유클리드 호제법
    Integer result;
    public Integer uclid(Integer num1, Integer num2) {
        if(num1 >= num2) {
            if(num1 % num2 == 0 ) {
                this.result = num2;
            } else {
                uclid(num2, num1%num2);
            }
        } else {
            if(num2 % num1 == 0) {
                this.result = num1;
            } else {
                uclid(num1, num2 % num1);
            }
        }
        return result;
    }
    public void display() {
        System.out.println(this.result);
    }
}
