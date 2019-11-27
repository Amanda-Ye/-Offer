
/*1.二维数组中的查找：
在一个二维数组中（每个一维数组的长度相同），
每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，“输入”这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Task1 {

    //解题思路：利用有序的优势 从右上角（或左下角）开始遍历，
    // 若 array[i][j] > target 则 j--
    //若 array[i][j]  < target 则 i++
    //循环条件为 i > 0 && j <
    public boolean Find(int target, int [][] array) {
        int i = 0;
        int j = array[0].length - 1;
        while(i < array.length && j >= 0){
            if(array[i][j] == target){
                return true;
            }else if(array[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

}
