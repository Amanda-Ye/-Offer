/**
 * 13.调整数组顺序使奇数位于偶数前面：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

//！！！代码的完整性
public class Reorder {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0) {
            return;
        }
        int m = 0;
        for(int i = 0;i < array.length;i++){
            if((Math.abs(array[i])) % 2 != 0){ //每遇到一个奇数就对它前一个奇数之间的偶数进行调整
                int tmp = array[i];
                int j = i;
                while(j > m){
                    array[j] = array[j-1];
                    j--;
                }
                m=j+1;
                array[j] = tmp;
            }
        }
    }

    public void reOrderArray2(int[] arr){
        if(arr == null || arr.length == 0 || arr.length == 1){
            return;
        }
        int i = 0;
        while(i < arr.length){
            int j = i + 1;
            if((arr[i] % 2) == 0){
                while((arr[j] % 2) == 0){    //直到遇到奇数停下进行交换
                    if(j == arr.length -  1){
                        return;
                    }
                    j++;
                }
                //进行交换
                int val = arr[i];   //保存偶数
                arr[i] = arr[j];
                while(j > i + 1){
                    arr[j] = arr[j - 1];   //依次后移
                    j--;
                }
                arr[j] = val;
            }
            i++;
        }
    }
}
