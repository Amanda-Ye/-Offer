import java.util.Arrays;

/**
 * 28.数组中出现次数超过一半的数字:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

public class OnlyOneTime {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int count = 1;
        int val = array[0];
        for(int i = 1;i < array.length;i++){
            if(array[i] == val){
                count++;
            }else{
                count--;
                if(count == 0){
                    val = array[i];
                    count++;
                }
            }
        }
        //判断最后所得值是否真的大于一半
        count = 0;
        for(int i = 0;i < array.length;i++){
            if(array[i] == val){
                count++;
            }
        }
        return count > array.length / 2 ? val : 0;
    }

    public int MoreThanHalfNum_Solution2(int [] array) {
        Arrays.sort(array);
        int val = array[array.length / 2];
        //判断最后所得值是否真的大于一半
        int count = 0;
        for(int i = 0;i < array.length;i++){
            if(array[i] == val){
                count++;
            }
        }
        return count > array.length / 2 ? val : 0;
    }
}
