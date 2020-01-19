import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * 54.字符流中第一个不重复的字符：
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述：如果当前字符流没有存在出现一次的字符，返回#字符。
 */

public class FromCharStream {
    LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
    public void Insert(char ch)
    {
        if(map.containsKey(ch)) {
            map.put(ch,-1);
        } else {
            map.put(ch, 1);
        }
    }
    public char FirstAppearingOnce()
    {
        Iterator<Character> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            char cur = iterator.next();
            if(map.get(cur) == 1) {
                return cur;
            }
        }
        return '#';
    }


    //仿照hash表实现，str存储插入的字符，hash[256]存储插入字符的个数
    private String str;
    private int[] hash = new int[256];  //存储插入对应字符的个数
    //Insert one char from stringstream
    public void Insert1(char ch) {
        str += ch;
        hash[ch]++;
    }
    //return the first appearence once char in current stringstream
    //遍历插入的字符（按照插入的顺序，可方便的得到第一个），hash表中个数为1的输出，否则返回#
    public char FirstAppearingOnce1() {
        for(char c : str.toCharArray()){
            if(hash[c] == 1){
                return c;
            }
        }
        return '#';
    }
}
