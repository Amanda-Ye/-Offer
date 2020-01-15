/**
 * 24.二叉树中和为某一值的路径：
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */

import java.util.ArrayList;                      /*不通过*/

public class Roads {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null){
            return result;
        }
        list.add(root.val);
        int differ = target - root.val;
        if(differ == 0 && root.left == null && root.right == null){
            result.add(list);
            return result;
        }

        //分别求得左右子树的路径序列
        ArrayList<ArrayList<Integer>> leftRes = FindPath(root.left,differ);
        ArrayList<ArrayList<Integer>> rightRes = FindPath(root.right,differ);

        //及时将当前路径的根值插入到前面
        addValToPath(leftRes, root.val);
        addValToPath(rightRes, root.val);

        //保证数组长度长的排在前面
        int left = 0,right = 0;
        while(left < leftRes.size() && right < rightRes.size()){
            if(leftRes.get(left).size() >= rightRes.get(right).size()){
                result.add(leftRes.get(left));
                left++;
            }else{
                result.add(rightRes.get(right));
                right++;
            }
        }
        while(left < leftRes.size()){
            result.add(leftRes.get(left++));
        }
        while(right < rightRes.size()){
            result.add(rightRes.get(right++));
        }

        return result;
    }

    private void addValToPath(ArrayList<ArrayList<Integer>> res, int val) {
        for(ArrayList<Integer> list : res){
            list.add(0,val);
        }
    }
}
