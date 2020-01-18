/**
 * 49.把字符串转换成整数：
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述：输入一个字符串,包括数字字母符号,可以为空
 * 输出描述：如果是合法的数值表达则返回该数字，否则返回0
 */

public class StringToInt {
    public static int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        int flag = 1;
        int i = 0;
        while(str.charAt(i) == ' '){
            i++;  //如果为空格，顺序后移
        }
        if(str.charAt(i) == '-'){
            flag = -1;   //标志为负数
            i++;
        }else if(str.charAt(i) == '+'){
            flag = 1;   //标志为正数
            i++;
        }
        double res = 0;   //考虑到越界问题，故不应该定义为 int 类型
        while(i < str.length()){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                res = (res * 10) + (str.charAt(i) - '0');
                i++;
            }else{
                return 0;
            }
        }
        if(flag == -1){
            if((0 - res) < Integer.MIN_VALUE){
                return 0;
            }else {
                return (int)(flag * res);
            }
        }else{
            if(res > Integer.MAX_VALUE){
                return 0;
            }else{
                return (int)res;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("-2147483649"));   // 0
        System.out.println(StrToInt("-2147483648"));   //-2147483648
    }
}
