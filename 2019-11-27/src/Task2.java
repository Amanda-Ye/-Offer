
/*2.替换空格：
* 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
* 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。*/
public class Task2 {
    public String replaceSpace1(StringBuffer str) {
        String temp = str.toString();
        String[] strs = temp.split(" ");
        StringBuilder result = new StringBuilder();
        result.append(strs[0]);
        for(int i = 1;i < strs.length;i++){
            result.append("%20");
            result.append(strs[i]);
        }
        return result.toString();    //通过率 25%
    }

    public String replaceSpace2(StringBuffer str) {
        StringBuilder ret = new StringBuilder();
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) != ' '){
                ret.append(str.charAt(i));
            }else{
                ret.append("%20");
            }
        }
        return ret.toString();   //通过全部测试用例
    }

    public String replaceSpace3(StringBuffer str) {
        return str.toString().replace(" ","%20");  //调用自带方法
    }
}
