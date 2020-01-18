/**
 * 47.求 1 + 2 + 3 + ... + n：
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

public class CalculateSum {
    //短路 与
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum != 0 ) && ((sum += Sum_Solution(n - 1)) != 0);
        // n == 1 时直接返回 1
        //boolean flag = (sum > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    /*题解：
    思路：这是一个等差数列，sum=(a1+an)n/2=>(1+n)n/2=>(n+n^2)/2；
    Math.pow(a,b)表示a^b；右移一位相当于除以2。
     */
    public int Sum_Solution2(int n) {
        int sum = (int) (Math.pow(n,2) + n);
        return sum >> 1;
    }

    //不符合要求通过
    public int Sum_Solution1(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int res = 1;
        for(int i = 2;i <= n;i++){
            res = add(res,i);
        }
        return res;
    }

    private int add(int i, int j) {
        return j != 0 ? add(i ^ j,(i & j) << 1) : i;
    }
}
