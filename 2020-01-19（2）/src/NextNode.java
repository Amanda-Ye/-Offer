import java.util.ArrayList;
import java.util.List;

/**
 * 57.二叉树的下一个结点：
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;  //指向父结点

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class NextNode {
    /**
     * 方法2：分情况讨论
     * 1.给定结点有右子树，下一个结点则为其右子树中的最左结点
     * 2.给定结点无右子树，下一个结点必定为该节点的父辈节点。但是究竟是哪一辈呢？
     * 根据中序遍历特性，左父结点一定已经被中序遍历访问过，所以下一个结点一定是在父节点路径上的第一个右父节点。
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode == null) return null;

        //给定结点有右子树
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null)
                pNode = pNode.left;
            return pNode;
        }

        //给定结点没有右子树
        while(pNode.next != null){
            if(pNode.next.left == pNode)
                return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }

    //方法1：中序遍历
    List<TreeLinkNode> list = new ArrayList<>();
    public TreeLinkNode GetNext1(TreeLinkNode pNode){
        //1.先找到根结点
        TreeLinkNode root = pNode;
        while(root.next != null){
            root = root.next;
        }
        //2.中序遍历
        InOrder(root);
        //3.找到指定结点的下一个结点并返回
        for(int i = 0;i < list.size();i++){
            if(pNode == list.get(i)){
                return i == list.size() - 1 ? null : list.get(i + 1);
            }
        }
        return null;
    }

    private void InOrder(TreeLinkNode root) {
        if(root != null){
            InOrder(root.left);
            list.add(root);
            InOrder(root.right);
        }
    }
}
