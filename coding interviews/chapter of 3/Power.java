/**
 * Created by 11981 on 2017/3/19.
 * 面试题11：数值的整数次方
 * 需要考虑指数为负和零的情况
 */
public class Power {
    public static void main(String[] args) throws Exception{
        Power p = new Power();
        System.out.println(p.power(100.0,2));
        System.out.println(p.power(100.0,-2));
        System.out.println(p.power(100.0,0));
        System.out.println(p.power(0.0,-2));

    }
    public double power(double base, int exponent) throws Exception{
        double result = 0.0;
        if (equals(base, 0.0) && exponent < 0){
            throw new Exception("0的负数次幂没有意义");
        }
        if (exponent < 0){
            result =  1.0/powerWithExponent(base, -exponent);
        }else if (exponent >= 0){
            result =  powerWithExponent(base, exponent);
        }
        return result;
    }

    private double powerWithExponent(double base, int exponent){
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        double result = 1.0;
        for (int i=1; i <= exponent; i++){
            result  = result * base;
        }

        return result;
    }

    private boolean equals(double num1, double num2){
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001)){
            return true;
        }else{
            return false;
        }

    }
}
