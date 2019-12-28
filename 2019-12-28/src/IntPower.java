/**
 * 12.数值的整数次方：
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */

//!!!代码的完整性:考虑底数或指数可能有一个为0，指数可正可负
public class IntPower {
    public double Power(double base, int exponent) {     //用时50ms
        if(exponent == 0){
            return 1.0;
        }
        boolean flag = false;
        if(exponent < 0){
            flag = true;
            exponent = -exponent;    //调整指数
        }
        double ret = 1.0;
        while(exponent > 0){
            ret *= base;
            exponent--;
        }
        return flag ? 1 / ret : ret;
    }

    public double Power2(double base, int exponent) {     //用时40ms
        if(exponent < 0){
            base = 1 / base;      //调整底数
            exponent = -exponent;  //更改指数
        }
        double ret = 1.0;
        while(exponent > 0){
            if((exponent & 1) == 1){
                ret *= base;
            }
            exponent >>= 1;   //右移一位，相当于扩大一倍
            base *= base;
        }
        return ret;
    }

    //递归
    public static double Power3(double base, int exp) {
        boolean flag = exp < 0;
        if (flag) {
            exp = -exp;
        }
        double result = getPower(base, exp);
        return flag ? 1 / result : result;
    }

    public static double getPower(double base, int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return base;
        }
        double ans = getPower(base, exp >> 1);
        ans *= ans;
        if ((exp & 1) == 1) {
            ans *= base;
        }
        return ans;
    }
}
