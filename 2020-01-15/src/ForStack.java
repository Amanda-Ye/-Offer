/**
 * 21.栈的压入、弹出序列：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。（这两个序列的长度是相等的）
 */

import java.util.Stack;

/**
 * 解题思路：
 * 按照入栈序列对元素依次进行如入栈，每次入栈后与出栈序列比较，
 * 若相等，则执行出栈操作。并更新出栈序列下一个比较元素的下标；
 * 反之，继续入栈。
 */
public class ForStack {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> in = new Stack<Integer>();
        int index = 0;   //出栈元素下标
        for(int i = 0;i < pushA.length;i++){
            in.push(pushA[i]);
            //此处不能使用if，若有连续元素相等，则需连续出栈
            while(index < popA.length && in.peek() == popA[index]){
                in.pop();
                index++;
            }
        }
        return in.isEmpty();  //若栈为空，则序列正确
    }
}
