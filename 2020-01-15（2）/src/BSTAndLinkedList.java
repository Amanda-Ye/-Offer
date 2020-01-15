import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 26.二叉搜素树与双向链表:
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class BSTAndLinkedList {
    //方法3：利用栈中序遍历
    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            return null;
        }
        TreeNode head = pRootOfTree;
        TreeNode tmp = null;
        Stack<TreeNode> stack = new Stack<>();
        while(head != null || !stack.isEmpty()){
            if(head != null){
                stack.push(head);
                head = head.left;
            }else{
                TreeNode pop = stack.pop();
                head = pop;
                if(tmp != null){
                    tmp.right = pop;
                }
                pop.left = tmp;
                tmp = pop;
                head = head.right;
            }
        }
        while(tmp.left != null){
            tmp = tmp.left;
        }
        return tmp;
    }

    //方法2：递归
    TreeNode pre = null;
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        Convert(pRootOfTree.right);
        if(pre == null){
            pre = pRootOfTree;
        }else{
            pRootOfTree.right = pre;
            pre.left = pRootOfTree;
            pre = pRootOfTree;
        }
        Convert(pRootOfTree.left);
        return pre;
    }

    //方法1：利用额外的数组来保存中序遍历序列，然后依次改变结点指针指向
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(pRootOfTree,list);
        return redirect(list);
    }
    //中序遍历
    private void inOrder(TreeNode root,ArrayList<TreeNode> list){
        if(root.left != null){
            inOrder(root.left,list);
        }
        list.add(root);
        if(root.right != null){
            inOrder(root.right,list);
        }
    }
    //改变指针指向（双向链表）
    private TreeNode redirect(ArrayList<TreeNode> list){
        for(int i = 0;i < list.size() - 1;i++){
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }
}
