/**
 * 31.整数中 1 出现的次数：
 * 求出任意非负整数区间中1出现的次数（从1 到 n 中 1 出现的次数）。
 */

public class CountOfOne {
    /**
     * 题解：数学归纳计算法
     * 个位数上的1的个数：(n/10)1 + if(n%10)<1 ? 0 : ((n%10-1)+1)
     * *十位数上的1的个数：(n/100)10 + if(n%100)<10 ? 0: ((n%100-10)+1)
     * *百位数上1的个数：(n/1000)100 + if(n%1000)<100 ? 0: ((n%1000-100)+1)
     * *总计i：*(n/(10i))i + if(n%(10i))< i ? 0 : ((n%(10*i)-i)+1)
     * i是小于n的最高位数目：i=pow(10, log10(n))
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0) return 0;
        int count = 0;
        for(int i = 1; i <= n; i *= 10){
            //计算在第i位上总共有多少个1
            count = count + (n / (10 * i)) * i;
            //不足i的部分有可能存在1
            int mod = n % (10 * i);
            //如果超出2*i -1，则多出的1的个数是固定的
            if(mod > 2 * i - 1){
                count += i;
            }else{
                //只有大于i的时候才能会存在1
                if(mod >= i) {
                    count += (mod - i) + 1;
                }
            }
        }
        return count;
    }

    //方法2（算术思路：取模，除十）
    public int NumberOf1Between1AndN_Solution2(int n) {
        if(n == 0){
            return 0;
        }
        if(n < 10){
            return 1;
        }
        int count = 0;
        while(n > 0){
            int i = n;
            while(i > 0){
                if(i % 10 == 1){
                    count++;
                }
                i /= 10;
            }
            n--;
        }
        return count;
    }
    //方法2简化：
    public int NumberOf1Between1AndN_Solution22(int n) {
        int count = 0;
        for(int i = 1;i <= n;i++){
            for(int j = i;j > 0;j /= 10){
                if(j % 10 == 1){
                    count++;
                }
            }
        }
        return count;
    }

    //方法1（将整数转换为 字符串-->字符数组）
    public int NumberOf1Between1AndN_Solution1(int n) {
        if(n == 0){
            return 0;
        }
        if(n < 10){
            return 1;
        }
        int count = 0;
        for(int i = 1;i <= n;i++){     // n 个数
            String str = String.valueOf(i);    //转换为字符串操作每一个整数
            char[] tmp = str.toCharArray();
            for(int j = 0;j < tmp.length;j++){
                if(tmp[j] == '1'){
                    count++;
                }
            }
        }
        return count;
    }
}
