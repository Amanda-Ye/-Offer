import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 22.从上往下打印二叉树：
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

/**关于Queue:
 * 1.容量不够或队列为空时不会抛异常：offer（添加队尾元素）、peek（访问队头元素）、poll（访问队头元素并移除）
 * 2.容量不够或队列为空时抛异常：add（添加队尾元素）、element（访问队列元素）、remove（访问队头元素并移除）
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class LevelPrint {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return list;
        }
        //queue.add(root);
        queue.offer(root);
        while(!queue.isEmpty()) {
            //TreeNode node = queue.remove();
            TreeNode node = queue.poll();     //依次取出队首元素，并将其子节点插入队列
            list.add(node.val);
            if(node.left != null){
                //queue.add(node.left);
                queue.offer(node.left);
            }
            if(node.right != null){
                //queue.add(node.right);
                queue.offer(node.right);
            }
        }
        return list;
    }
}
