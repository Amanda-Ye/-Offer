import java.util.HashMap;
import java.util.Map;

/**
 * 40.数组中只出现一次的数字：
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class OnlyOneTime {
    /**
     * 经典题解：位运算
     * 首先依次进行异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的 不同的位。
     * 我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。
     * 如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
     * 然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int tmp = 0;
        for(int i = 0;i < array.length;i++){
            tmp ^= array[i];
        }
        int index = 1;
        while((index & tmp) == 0){
            index <<= 1;   //确认第一个 1 所在位置，依次将数组分为两部分
        }
        num1[0] = 0;
        num2[0] = 0;
        for(int i = 0;i < array.length;i++){
            if((array[i] & index) == 0){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < array.length;i++){
            int cnt = map.getOrDefault(array[i],0);
            map.put(array[i],cnt + 1);
        }
        int count = 0;
        for(int i = 0;i < array.length;i++){
            if(map.get(array[i]) == 1){
                if(count == 0){
                    num1[0] = array[i];
                    count++;
                }else{
                    num2[0] = array[i];
                }
            }
        }
    }
}
