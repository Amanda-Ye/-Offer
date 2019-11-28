import java.util.ArrayList;
/*3.从尾到头打印链表：
* 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。*/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class ReversePrint {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = listNode;
        while(cur != null){
            list.add(0,cur.val);  //此处并不会发生元素存放冲突！！！
            cur = cur.next;
        }
        return list;
    }
}
