/**
 * 41.和为S的连续正数序列：
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */

import java.util.ArrayList;
import java.util.Arrays;

public class PositiveSequence {
    //通过！！！哦耶耶耶
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        if(sum <= 0){
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 1;i < sum - 1;i++){
            int val = i;
            for(int j = i + 1;j < sum;j++){
                val += j;
                if(val == sum){
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int k = i;k <= j;k++){
                        list.add(k);
                    }
                    res.add(list);
                    break;
                }else if(val > sum){
                    break;
                }
            }
        }
        return res;
    }
}
