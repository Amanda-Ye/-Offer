/**
 * 35.数组中的逆序对：
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P % 1000000007
 */

public class Reverse {
    //分治思想 归并
    private int count = 0;
    public int InversePairs(int [] array) {
        MergeSort(array,0,array.length - 1);
        return count;
    }
    private void MergeSort(int[] array, int start, int end) {
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;
        MergeSort(array,start,mid);
        MergeSort(array,mid + 1,end);
        MergeOne(array,start,mid,end);
    }
    private void MergeOne(int[] array, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int k = 0;
        int i = start,j = mid + 1;
        while(i <= mid && j <= end){
            if(array[i] <= array[j]){   //前面元素小于等于后面元素1，不构成逆序对
                tmp[k++] = array[i++];  //进行排序
            }else{
                tmp[k++] = array[j++];   //进行排序
                count = (count + mid - i + 1) % 1000000007;  //前面元素大于后面元素，构成逆序对
            }
        }
        //将剩余元素插入数组
        while(i <= mid){
            tmp[k++] = array[i++];
        }
        while(j <= end){
            tmp[k++] = array[j++];
        }
        //将排好顺序的数组搬移到原数组
        for(int m = 0;m < k;m++){
            array[start + m] = tmp[m];
        }
    }


    public int InversePairs1(int [] array) {             //运行超时
        if(array == null || array.length == 0){
            return 0;
        }
        int count = 0;
        for(int i = 0;i < array.length - 1;i++){
            for(int j = i + 1;j < array.length;j++){
                if(array[i] > array[j]){
                    count++;
                }
            }
        }
        return count % 10_0000_0007;
    }
}
