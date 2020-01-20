import java.util.Map;
import java.util.TreeMap;
import java.util.PriorityQueue;


/**
 * 63.数据流中的中位数：（知识点：进制转化）
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */

public class MedianNum {
    /**
     * 题解：利用两个堆：
     * 用于存储输入数字中较小一半的最大堆（最大堆中的所有数字都小于或等于最大堆的top元素）
     * 用于存储输入数字的较大一半的最小堆（最小堆中的所有数字都大于或等于最小堆的顶部元素）
     * 只要这两个堆是平衡的（即这两个堆的数量相等或相差1），那么中位数就可以通过这两个堆的堆顶元素获得
     */
    private PriorityQueue<Integer> min = new PriorityQueue<>();   //小根堆
    private PriorityQueue<Integer> max = new PriorityQueue<>((a, b)->b-a);   //大根堆

    public void Insert1(Integer num) {
        max.add(num);
        min.add(max.remove());
        if (min.size() > max.size())
            max.add(min.remove());  //保证大根堆比小根堆数量多1 或者 两根数量相等
    }

    public Double GetMedian1() {
        if (min.size() == max.size()){
            return (max.peek() + min.peek()) / 2.0;
        } else{
            return(double)max.peek();
        }
    }


    //方法2：利用java中的数据结构 TreeMap
    TreeMap treeMap = new TreeMap<Integer,Integer>();
    public void Insert(Integer num) {
        if(treeMap.containsKey(num)) {
            int sum = (Integer) treeMap.get(num);
            treeMap.replace(num, sum, sum + 1);
        }else {
            treeMap.put(num,1);
        }
    }

    public Double GetMedian() {
        int size = treeMap.size();
        Map.Entry entry = treeMap.firstEntry();
        int i = (int)entry.getValue();
        int mid = (size+1)/2;
        while(i < mid){
            entry = treeMap.higherEntry(entry.getKey());
            i += (int)entry.getValue();
        }
        if(size % 2 == 0 && i == mid){
            return ((int)entry.getKey() * 1.0 + (int)treeMap.higherEntry(entry.getKey()).getKey() * 1.0) / 2;
        }
        return (int)entry.getKey() * 1.0;
    }
}
