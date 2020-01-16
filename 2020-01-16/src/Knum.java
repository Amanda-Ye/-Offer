import java.util.ArrayList;
import java.util.Arrays;

/**
 * 29.最小的K个数：
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

public class Knum {
    //方法2
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k){
        if(input == null || input.length == 0 || k <= 0 || k > input.length){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0;i < k;i++){                            //冒泡 K 次
            for(int j = i + 1;j < input.length;j++){
                if(input[j] < input[i]){
                    swap(input,i,j);
                }
            }
        }
        for(int i = 0;i < k;i++){
            res.add(input[i]);
        }
        return res;
    }
    private void swap(int[] input,int i,int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    //方法1
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        if(input == null || input.length == 0 || k <= 0 || k > input.length){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(input);   //对数组排序，取前 k 个数
        for(int i = 0;i < k;i++){
            res.add(input[i]);
        }
        return res;
    }
}
