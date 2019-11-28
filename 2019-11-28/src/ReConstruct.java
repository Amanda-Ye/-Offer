import java.util.Arrays;

/*4.重建二叉树：
* 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
* 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
* 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
* 则重建二叉树并返回。*/

/*解题思路：（先判断序列是否为空）
* （1）确定先序序列第一个元素 preOrder[0] 必定为根值，创建根结点 root
* （2）在中序序列中找到根值元素所在的 index
* （3）index 可以将中序序列划分为 leftInorder（index 前面）和 rightInorder（index 后面）
* （4）利用index 可以计算出 leftPreorder（1~1+index左闭右开）和rightPreorder（剩下部分）
* （5）递归操作创建root.left 和 root.right
* （6）返回 root 即可
* */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class ReConstruct {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0){
            return null;
        }
        int rootVal = pre[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for(int i = 0;i < in.length;i++){  //在中序序列中找根值的 index
            if(in[i] == rootVal){
                rootIndex = i;
            }
        }
        int[] leftPre = Arrays.copyOfRange(pre,1,1 + rootIndex);
        int[] rightPre = Arrays.copyOfRange(pre,1 + rootIndex,pre.length);
        int[] leftIn = Arrays.copyOfRange(in,0,rootIndex);
        int[] rightIn = Arrays.copyOfRange(in,rootIndex + 1,in.length);
        TreeNode leftTree = reConstructBinaryTree(leftPre,leftIn);
        TreeNode rightTree = reConstructBinaryTree(rightPre,rightIn);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}
