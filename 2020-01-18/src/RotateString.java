/**
 * 43.旋转字符串：
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */

public class RotateString {
    //方法2：截取 + 拼接
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0 || n == 0){
            return str;
        }
        if(n >= str.length()){
            n %= str.length();  //实际需要左移的位数
        }
        return str.substring(n) + str.substring(0,n);
    }

    //方法1：左移
    public String LeftRotateString1(String str,int n) {
        if(str == null || str.length() == 0 || n == 0){
            return str;
        }
        char[] tmp = str.toCharArray();
        int i;
        while(n > 0){
            char c = tmp[0];
            for(i = 1;i < tmp.length;i++){
                tmp[i - 1] = tmp[i];
            }
            tmp[i - 1] = c;
            n--;
        }
        StringBuilder sb= new StringBuilder();
        for(i = 0;i < tmp.length;i++){
            sb.append(tmp[i]);
        }
        return sb.toString();
    }
}
