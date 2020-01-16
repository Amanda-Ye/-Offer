/**
 * 34.第一个只出现一次的字符：
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中
 * 找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）
 */

import java.util.TreeMap;
import java.util.Map;

public class FirstOnlyChar {
    //如果该字符只出现一次，那么从前开始查找和从后开始查找，找到的下标都应该是同一个。
    //方法2：不用辅助空间
    public int FirstNotRepeatingChar(String str){
        int len = str.length();
        if(str == null || len == 0){
            return -1;
        }
        for(int i = 0;i < len;i++){
            char tmp = str.charAt(i);
            if(str.indexOf(tmp) == i && str.lastIndexOf(tmp) == i){
                return i;
            }
        }
        return -1;
    }

    //方法1：利用辅助空间
    public int FirstNotRepeatingChar1(String str) {
        int len = str.length();
        if(str == null || len == 0){
            return -1;
        }
        Map<Character,Integer> map = new TreeMap<>();            //用时较长
        int i = 0;
        for(i = 0;i < len;i++){
            int count = map.getOrDefault(str.charAt(i),0);
            map.put(str.charAt(i),count + 1);
        }
        for(i = 0;i < len;i++){
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
