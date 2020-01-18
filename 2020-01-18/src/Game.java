import java.util.ArrayList;
import java.util.List;

/**
 * 46.孩子们的游戏：
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
 * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */

public class Game {
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1){
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < n;i++){
            list.add(i);
        }
        int index = -1;
        while(list.size() > 1){
            for(int i = 0;i < m;i++){
                index++;
                if(index == list.size()){
                    index = 0;
                }
            }
            list.remove(index);
            index--;  //cur--的原因，因为新的list中cur指向了下一个元素，为了保证移动m个准确性，所以cur向前移动一位。
        }
        return list.get(0);
    }

    //环形链表
    class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }
    public int LastRemaining_Solution2(int n, int m) {
        if(n < 1 || m < 1){
            return -1;
        }
        //将数字进行链接
        ListNode head = new ListNode(0);  //创建头结点
        ListNode node = head;
        for(int i =1;i < n;i++){
            node.next = new ListNode(i);
            node = node.next;
        }
        node.next = head;   //环形链表
        while(node.next != node){
            for(int i = 0;i < m;i++){
                if(i == m - 1){
                    node.next = node.next.next; //进行删除
                }else{
                    node = node.next;
                }
            }
        }
        return node.val;
    }
}
