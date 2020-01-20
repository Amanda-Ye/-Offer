import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 59.按之字形顺序打印二叉树：
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class PrintTree {
    //利用两个栈，一个存储奇数层结点，一个存储偶数层结点
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<TreeNode>();  //奇数层
        Stack<TreeNode> s2 = new Stack<TreeNode>();  //偶数层
        boolean isEven = false;  //行标识
        s1.push(pRoot);  //第一层
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!isEven){  //奇数层
                Iterator<TreeNode> it = s1.iterator();  //从左往右
                while(it.hasNext()){
                    TreeNode tmp = s1.pop();
                    list.add(tmp.val);
                    if(tmp.left != null){
                        s2.push(tmp.left);
                    }
                    if(tmp.right != null){
                        s2.push(tmp.right);
                    }
                }
                res.add(new ArrayList<>(list));
                list.clear();
                isEven = !isEven;
            }else{   //偶数层
                Iterator<TreeNode> it = s2.iterator();  //从左往右
                while(it.hasNext()){
                    TreeNode tmp = s2.pop();
                    list.add(tmp.val);
                    if(tmp.right != null){
                        s1.push(tmp.right);
                    }
                    if(tmp.left != null){
                        s1.push(tmp.left);
                    }
                }
                res.add(new ArrayList<>(list));
                list.clear();
                isEven = !isEven;
            }
        }
        return res;
    }

    /**
     *答主：利用Java中的LinkedList的底层实现是双向链表的特点。
     * 1)可用做队列,实现树的层次遍历
     * 2)可双向遍历,奇数层时从前向后遍历，偶数层时从后向前遍历
     */
    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(null);  //层分隔符
        queue.add(pRoot);  //第一层
        boolean isEven = false;  //奇数层 从左到右
        while(queue.size() != 1){
            TreeNode node = queue.poll();
            if(node == null){
                Iterator<TreeNode> it = null;
                if(!isEven){  //奇数层
                    it = queue.iterator();  //从左往右
                }else{
                    it = queue.descendingIterator();  //从右往左
                }
                isEven = !isEven;  //改变行标识
                while(it.hasNext()){
                    TreeNode tmp = (TreeNode) it.next();
                    list.add(tmp.val);
                }
                res.add(new ArrayList<Integer>(list));
                list.clear();
                queue.addLast(null);  //添加层分隔符
                continue;
            }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return res;
    }
}
