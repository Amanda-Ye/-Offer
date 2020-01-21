package dynamic_planning;

/*
 * 动态规划的关键：             subset(i,s) ->subset(i - 1,s - arr[i])
 *                存在？  or
 *                             subset(i -  1,s)
 */

/**
 * 给定一个正整数s, 判断一个数组arr中，是否有一组数字加起来等于s。
 */
public class ThirdPractice {
    //非递归(约束数组中均为非负数)
    private static boolean dp_subset(int[] arr,int s){
        int l = arr.length;
        boolean[][] res = new boolean[l][s + 1];
        //特殊处理第0行
        for(int i = 0;i < s + 1;i++){
            if(arr[0] == i){
                res[0][i] = true;
            }else{
                res[0][i] = false;
            }
        }
        //特殊处理第0列
        for(int i = 0;i < l;i++){
            res[i][0] = true;
        }
        //处理其余位置
        for(int i = 1;i < l;i++){
            for(int j = 1;j < s + 1;j++){
                if(arr[i] > j){
                    res[i][j] = res[i - 1][j];
                }else{
                    res[i][j] = (res[i - 1][j - arr[i]] || res[i - 1][j]);
                }
            }
        }
        return res[l - 1][s];
    }

    //递归(约束数组中均为非负数)
    private static boolean rec_subset(int[] arr,int i,int s){
        //关键：递归出口的判断
        if(s == 0){
            return true;
        }
        if(i == 0){
            return arr[i] == s;
        }
        if(arr[i] > s){
            return rec_subset(arr,i - 1,s);
        }
        return rec_subset(arr,i - 1,s - arr[i]) || rec_subset(arr,i - 1,s);
    }

    public static void main(String[] args) {
        int[] arr = {3,34,4,12,5,2};
        int s1 = 9;
        int s2 = 13;
        System.out.println(rec_subset(arr,arr.length - 1,s1));
        System.out.println(rec_subset(arr,arr.length - 1,s2));
        System.out.println(dp_subset(arr,s1));
        System.out.println(dp_subset(arr,s2));
    }
}
