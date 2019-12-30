import java.util.LinkedList;
import java.util.Queue;

/**
 * 18.二叉树的镜像：（面试思路）
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class TreeMirror {
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        Mirror(root.left);
        Mirror(root.right);
    }

    public void Mirror2(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        Mirror(root.left);
        Mirror(root.right);
    }

    public void Mirror3(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        if(root.left != null){
            Mirror(root.left);
        }
        if(root.right != null){
            Mirror(root.right);
        }
    }

    //非递归
    //镜像就是将“根”节点的左右两个“子”节点互换，类似于数组的元素交换（运用临时节点temp）
    //利用二叉树的广度优先搜索即可
    public void Mirror4(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur,temp;
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0;i < len;i++){
                cur = queue.poll();
                temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
    }
}
