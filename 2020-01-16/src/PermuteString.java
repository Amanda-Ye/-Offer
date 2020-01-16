import java.util.ArrayList;
import java.util.Arrays;

/**
 * 27.字符串的排列：
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 注：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

public class PermuteString {
    public ArrayList<String> Permutation(String str) {
        StringBuilder sb = new StringBuilder(str);
        ArrayList<String> result = permutationHelp(sb);
        return result;
    }

    private ArrayList<String> permutationHelp(StringBuilder sb) {
        ArrayList<String> result = new ArrayList<>();
        if(sb.length() == 1){
            result.add(sb.toString());
        }
        else{
            for(int i = 0;i < sb.length();i++){
                if(i == 0 || sb.charAt(i) != sb.charAt(0)){
                    char temp = sb.charAt(i);
                    sb.setCharAt(i,sb.charAt(0));
                    sb.setCharAt(0,temp);
                    ArrayList<String> res = permutationHelp(new StringBuilder(sb.substring(1)));
                    for(int j = 0;j < res.size();j++){
                        result.add(sb.substring(0,1) + res.get(j));
                    }
                    //交换使用后再换回原来的顺序
                    temp = sb.charAt(0);
                    sb.setCharAt(0,sb.charAt(i));
                    sb.setCharAt(i,temp);
                }
            }
        }
        //还需再做一个排序操作
        //Arrays.sort(result.toArray());
        for(int i = 0;i < result.size() - 1;i++){                         //用时过长
            for(int j = i + 1;j < result.size();j++){
                if(result.get(i).compareTo(result.get(j)) > 0){
                    swap(result,i,j);
                }
            }
        }
        return result;
    }

    private void swap(ArrayList<String> result, int i, int j) {
        String temp = result.get(i);
        result.set(i,result.get(j));
        result.set(j,temp);
    }
}