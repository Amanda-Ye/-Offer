/**
 * 30.连续子数组的最大和：
 * 给一个数组，返回它的最大连续子序列的和（子向量的长度至少是 1 ）
 */

public class BiggestSum {
    /**动态规划：
     * 最大子数组的和一定是由当前元素和之前最大连续子数组的和叠加在一起形成的，
     * 因此需要遍历n个元素，看看当前元素和其之前的最大连续子数组的和能够创造新的最大值。
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        int[] tmp = new int[len];
        int max = array[0];
        tmp[0] = array[0];
        for(int i = 1;i < len;i++){
            int newMax = tmp[i - 1] + array[i];
            if(newMax > array[i]){
                tmp[i] = newMax;
            }else{
                tmp[i] = array[i];
            }
            if(tmp[i] > max){
                max = tmp[i];
            }
        }
        return max;
    }
}
