
/*8.跳台阶：
* 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。
* 求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。*/
public class DanceSteps {
    public int JumpFloor(int target) {
        if(target == 0 || target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);  //耗时长
    }

    public int JumpFloor1(int target){
        if(target == 0 || target == 1){
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for(int i = 0;i < target - 1;i++){   //循环更优更快
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
