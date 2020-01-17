import java.util.Arrays;

/**
 * 37.数字在排序数组中出现的次数：
 * 统计一个数字在排序数组中出现的次数。
 */

public class CountOfNum {
    //一提到有序，立马想到二分查找
    public int GetNumberOfK(int[] array, int k) {
        int index = Arrays.binarySearch(array, k);  //二分查找该元素的位置
        if(index < 0)return 0;
        int cnt = 1;
        for(int i = index+1; i < array.length && array[i] == k;i++)
            cnt++;
        for(int i = index-1; i >= 0 && array[i] == k;i--)
            cnt++;
        return cnt;
    }

    public int GetNumberOfK1(int[] array, int k) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            }
        }
        return count;
    }
}
