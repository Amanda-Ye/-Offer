/**
 * 9.变态跳台阶：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class AnotherDanceSteps {
    //方法1：循环（用时30ms）
    public int JumpFloorII(int target) {
        if(target == 0 || target == 1){
            return 1;
        }
        int ret = 1;
        for(int i = 0;i < target - 1;i++){
            ret *= 2;
        }
        return ret;    //2^(target - 1)种方法
    }

    //方法2：递归（用时16ms）
    public int JumpFloorII2(int target) {
        if(target == 0 || target == 1){
            return 1;
        }
        return 2 * JumpFloorII2(target - 1);    //2^(target - 1)种方法
    }
}
