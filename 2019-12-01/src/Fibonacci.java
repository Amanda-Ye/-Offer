
/*7.斐波那契数列：
* 大家都知道斐波那契数列，现在要求输入一个整数n，
* 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39  */
public class Fibonacci {
    public int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return fib(n - 1) + fib(n - 2);  //递归程序简洁但耗时长
    }

    public int fib1(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        while(n - 2 > 0){    //更优更快
            c = a + b;
            a = b;
            b = c;
            n--;
        }
        return c;
    }
}
