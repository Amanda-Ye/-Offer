package dynamic_planning;

/*
 * 动态规划的关键：             选 :arr[i] + OPT(i - 2)
 *                 OPT(i) = max
 *                              不选:OPT(i - 1)
 */


/**
 * 在一个数组arr中，找出一组 不相邻 的数字，使得最后的和最大。
 */
public class SecondPractice {
    //非递归：数组中截至下标 i 的最优解
    private static int dp_optimal(int[] arr){  //数组不能为空
        int len = arr.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return arr[0];
        }
        int[] opt = new int[len];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0],arr[1]);
        for(int i = 2;i < len;i++){
            opt[i] = Math.max(arr[i] + opt[i - 2],opt[i - 1]);
        }
        return opt[len - 1];
    }

    //递归：数组中截至下标 i 的最优解
    private static int optimal(int[] vals,int i){  //数组不能为空
        //递归出口
        if(i == 0){
            return vals[0];
        }else if(i == 1){
            return Math.max(vals[0],vals[1]);
        }
        return Math.max(vals[i] + optimal(vals,i - 2),optimal(vals,i - 1));
    }

    public static void main(String[] args) {
        int[] vals = {1,2,4,1,7,8,3};
        int[] arr = {3};
        int[] nu = null;
        System.out.println(optimal(arr,arr.length - 1));
        System.out.println(dp_optimal(arr));
        //System.out.println(dp_optimal(nu));
    }
}
