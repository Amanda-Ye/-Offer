package dynamic_planning;

/**
 * 67.剪绳子：
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n > 1并且m > 1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入描述：输入一个数n，意义见题面。（2 <= n <= 60）
 */
public class Nowcoder {
    //方法1
    private int cutRope1(int target){
        return help(target,0);
    }
    private int help(int target, int max) {
        int maxValue = max;
        for(int i = 1;i < target;i++){
            maxValue = Math.max(maxValue,i * help(target - i,target - i));
        }
        return maxValue;
    }

    /**
     *方法2：贪心解法
     * 把绳长target剪成i段的最大值为：Math.pow(n, i - c) * Math.pow(n + 1, c)
     * 如：target=8 i=3时，ans=2^1*3^2
     * 然后在剪成2段、3段...x段中取最大值即可。
     */
    private int cutRope2(int target) {  //target 代表绳子长度
        int result = 0;
        for (int i = 2; i <= target; i++) {
            int n = target / i, c = target % i;
            int ans = (int) (Math.pow(n, i - c) * Math.pow(n + 1, c));  ///???
            if (ans > result) {
                result = ans;
            }
        }
        return result;
    }

    /**
     * 方法3：动态规划
     * f[i]表示长度为i的绳子的乘积最大值。
     * f[i] = Max{f[j]*f[i-j]} 0<j<i
     */
    private int cutRope3(int target){
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= target;i++){
            if(i != target){
                dp[i] = i;
            }
            for(int j = 1;j < i;j++){
                dp[i] = Math.max(dp[i],dp[j] * dp[i - j]);
            }
        }
        return dp[target];
    }

    /**
     * 方法4：数学问题(当number > 3时，绳子的长度尽可能为3)
     * 和相同求积最大，必然是各分量值越相近越大，问题是分成几个分量？
     */
    private int cutRope(int target){
        int res = 0;
        // 此处循环中的i是段的长度，等于1时指全是长度为1的段，不能等于number
        for (int i = 1; i != target; ++i){
            int a = target / i;
            int b = target % i;

            int temp = 0;
            if (b != 0)
                temp = (int) (Math.pow(i, a) * b);
            else
                temp = (int) Math.pow(i, a);

            if (temp > res)
                res = temp;
        }
        return res;
    }

}
