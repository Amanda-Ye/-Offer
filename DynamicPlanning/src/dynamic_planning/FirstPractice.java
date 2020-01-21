package dynamic_planning;

/*
 * 动态规划的关键：             选 :vals[i] + OPT(prev[i])
 *                 OPT(i) = max
 *                              不选:OPT(i - 1)
 */


/**
 * 加权项目时间计划问题：
 * 已知8个任务的时间区间以及任务酬劳如下：
 * 任务编号               时间区间             酬劳v      prev[i]     OPT(i)
 *     1                    [1,4]               5           0           5
 *     2                    [3,5]               1           0           5
 *     3                    [0,6]               8           0           8
 *     4                    [4,7]               4           1           9
 *     5                    [3,8]               6           0           9
 *     6                    [5,9]               3           2           9
 *     7                    [6,10]              2           3           10
 *     8                    [8,11]              4           5           13
 */

class Work{
    int start;   //开始时间
    int end;    //截止时间
    int pay;    //工作酬劳

    //prev[i] 的获取：if(Work[i - k].end <= Work[i].start)   prev[i] = i - k  (取离 i 最近的)

    //get() set()暂且省略...
}

public class FirstPractice {
    //(OPT)最优solution解

    //prev[i] 预先处理好
    private static int[] prev = {0,0,0,1,0,2,3,5};
    private static int[] vals = {5,1,8,4,6,3,2,4};  //已知任务酬劳
    private static int optimal(int i){
        if(i == 0){
            return 0;
        }
        if(i == 1){
            return 5;
        }
        return Math.max(optimal(i - 1),vals[i - 1] + optimal(prev[i - 1]));
    }

    public static void main(String[] args) {
        System.out.println(optimal(0));
        System.out.println(optimal(2));
        System.out.println(optimal(5));
        System.out.println(optimal(8));
    }
}
