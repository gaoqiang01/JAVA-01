/**
 * @param
 * @author silent
 * @time 14:21 2021/1/8
 * @description
 */
public class LocalVariableTest {

    public static void main(String[] args) {

        MovingAverage mo = new MovingAverage();

        int num1 = 1;
        int num2 = 2;

        mo.sumbit(num1);
        mo.sumbit(num2);
        double ave = mo.getAve();
    }

}
