/**
 * @param
 * @author silent
 * @time 14:26 2021/1/8
 * @description
 */
public class ForLoopTest {

    public static int[] sum = {1, 3, 5, 7};

    public static void main(String[] args) {
        MovingAverage mo = new MovingAverage();
        //miancode --->28行
//        for (int i : sum) {
//            mo.sumbit(i);
//
//        }
 
        //miancode --->22
        for (int i = 0; i < sum.length; i++) {
            mo.sumbit(sum[i]);
        }


            mo.getAve();
    }
}
