/**
 * 42.和为S的两个数字：
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */

import java.util.ArrayList;
public class TwoNums {
    //要意识到：最外层的乘积最小
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        if(array == null || array.length < 2){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        int slow = 0,high = array.length - 1;
        int cur = 0;
        while(slow < high){
            cur = array[slow] + array[high];
            if(cur < sum){
                slow++;
            }else if(cur > sum){
                high--;
            }else{
                res.add(array[slow]);
                res.add(array[high]);
                break;
            }
        }
        return res;
    }
}
