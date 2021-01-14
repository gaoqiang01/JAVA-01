/**
 * @param
 * @author silent
 * @time 14:18 2021/1/8
 * @description
 */
public class MovingAverage {

    private int count=0;
    private double sum=0.0d;


    public void sumbit(double val){
        count++;
        this.sum=val;

    }

    public double getAve(){
        if(0==this.count){
            return sum;
        }
        return this.sum/this.count;
    }


}
