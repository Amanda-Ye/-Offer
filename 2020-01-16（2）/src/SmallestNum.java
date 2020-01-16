/**
 * 32.把数组排成最小的数：
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

public class SmallestNum {
    /**
     * 比较两个字符串s1, s2大小的时候，先将它们拼接起来，
     * 比较s1+s2,和s2+s1那个大，如果s1+s2大，那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面。
     */
    public String PrintMinNumber(int [] numbers) {
        int len = numbers.length;
        if(numbers == null || len == 0){
            return "";
        }
        for(int i = 0;i < len - 1;i++){                 //冒泡排序
            for(int j = i + 1;j < len;j++){
                int num1 = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int num2 = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if(num1 > num2){
                    swap(numbers,i,j);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < len;i++){
            res.append(numbers[i]);
        }
        return res.toString();
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
