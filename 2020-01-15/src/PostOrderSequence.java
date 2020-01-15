/**
 * 23.二叉搜索树的后序遍历序列:
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

//二叉搜索树的特性：左子树 < 根 < 右子树
public class PostOrderSequence {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return isPostOrder(sequence,0,sequence.length - 1);
    }

    private boolean isPostOrder(int[] sequence, int start, int root) {
        if(start >= root){
            return true;
        }
        int key = sequence[root];
        int i;
        //找到左右子树的分界点
        for(i = start;i < root;i++){
            if(sequence[i] > key){
                break;
            }
        }
        //遍历右子树看是否包含小于key的值，若有则返回false
        for(int j = i;j < root;j++){
            if(sequence[j] < key){
                return false;
            }
        }
        return isPostOrder(sequence,start,i - 1) && isPostOrder(sequence,i,root - 1);
    }

}
