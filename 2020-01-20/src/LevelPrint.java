import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 60.把二叉树打印成多行：
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

public class LevelPrint {
    /**
     * 借鉴上一题解答思路：利用LinkedList
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();  //临时存储每一层
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(null);  //层分隔符
        queue.addLast(pRoot);
        while(queue.size() != 1){
            TreeNode node = queue.removeFirst();
            if(node == null){  //到达层分隔符,开始打印
                Iterator<TreeNode> it = queue.iterator();
                while(it.hasNext()){
                    TreeNode tmp = it.next();
                    list.add(tmp.val);
                }
                res.add(new ArrayList<>(list));
                list.clear();
                queue.addLast(null);   //添加层分隔符
                continue;  //若不执行continue，执行下面语句会报错
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
