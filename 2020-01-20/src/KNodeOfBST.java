import java.util.ArrayList;
import java.util.Stack;

/**
 * 62.二叉搜索树的第K个结点：
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */

public class KNodeOfBST {
    //方法3：非递归，用数据结构栈
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot == null || k <= 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = pRoot;
        while(!stack.isEmpty() || p != null){   //栈不为空 或 非叶子结点
            while(p != null){  //深度遍历最左结点即最小
                stack.push(p);
                p = p.left;
            }
            TreeNode ret = stack.peek();
            stack.pop();
            if((--k) == 0){  //每次循环都会减1
                return ret;
            }
            p = ret.right;
        }
        return null;
    }


    //方法1的改进：不一定需要全部遍历
    private int cnt = 0;
    private TreeNode ret = null;
    TreeNode KthNode2(TreeNode pRoot, int k){
        if(pRoot == null || k <= 0){
            return null;
        }
        inOrder2(pRoot,k);
        return ret;
    }
    private void inOrder2(TreeNode pRoot, int k) {
        if(cnt < k && pRoot.left != null){
            inOrder2(pRoot.left,k);
        }
        if(++cnt == k){
            ret = pRoot;  //关键终止条件
        }
        if(cnt < k && pRoot.right != null){
            inOrder2(pRoot.right,k);
        }
    }


    /*方法1：二叉搜素树中序遍历有序*/
    TreeNode KthNode1(TreeNode pRoot, int k){
        if(k <= 0){
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        list = inOrder(pRoot);
        if(k > list.size()){
            return null;
        }
        return list.get(k - 1);
    }
    private ArrayList<TreeNode> inOrder(TreeNode pRoot) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if(pRoot != null){
            list.addAll(inOrder(pRoot.left));
            list.add(pRoot);
            list.addAll(inOrder(pRoot.right));
        }
        return list;
    }
}
