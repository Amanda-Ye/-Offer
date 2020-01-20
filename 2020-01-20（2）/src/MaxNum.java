import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 64.滑动窗口的最大值：
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

public class MaxNum {
    /**方法2
     * 【摘书上】
     *  deque是一个双端队列，用来保存有可能是滑动窗口最大值数字的下标；
     *  在存入一个数字的下标之前，首先要判断队列里已有数字是否小于待存入的数字，如果小于则以此从队列的尾部删除；
     *  如果队列头部的数字已经从窗口滑出，那么滑出的数字也需要从队列的头部删除。
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<Integer> deque = new LinkedList<Integer>();
        if (num == null || size <= 0 || size > num.length) {
            return list;
        }
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                deque.removeLast();
            }
            if (!deque.isEmpty() && i - deque.peekFirst() >= size) {
                deque.removeFirst();
            }
            deque.addLast(i);
            if (i >= size - 1) {
                list.add(num[deque.peekFirst()]);
            }
        }
        return list;
    }

    //方法1
    public ArrayList<Integer> maxInWindows1(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = num.length;
        if(size <= 0 || size > len){
            return res;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i <= len - size;i++){
            max = num[i];
            for(int j = i;j < i + size;j++){
                if(num[j] > max){
                    max = num[j];
                }
            }
            res.add(max);
        }
        return res;
    }
}
