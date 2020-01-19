/**
 * 52.正则表达式匹配：
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */

public class RegularExpression {
    //题解:面面俱到有点难
    public boolean match(char[] str, char[] pattern) {   //pattern 模式
        return matchStr(str, 0, pattern, 0);
    }

    private boolean matchStr(char[] str, int i, char[] pattern, int j) {   //pattern 模式
        // 边界
        if (i == str.length && j == pattern.length) { // 字符串和模式串都为空
            return true;
        } else if (j == pattern.length) { // 模式串为空
            return false;
        }
        //分情况：模式串下一个字符是 '*' 或者 不是 '*'
        boolean flag = false;
        flag = (j + 1 < pattern.length && pattern[j + 1] == '*'); //模式串下一个字符是'*'
        if (flag) {
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                return matchStr(str, i, pattern, j + 2) || matchStr(str, i + 1, pattern, j);
            } else {
                return matchStr(str, i, pattern, j + 2);
            }
        } else {
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                return matchStr(str, i + 1, pattern, j + 1);
            } else {
                return false;
            }
        }
    }
}
