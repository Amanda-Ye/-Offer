import java.util.LinkedList;
import java.util.List;

/**
 * 55.链表中环的入口结点：
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class InNode {
    /**
     * 方法2：经典题解
     * 快慢指针。快指针一次走两步，慢指针一次走一步，设链表起点到入口结点的长度是x1，
     * 快慢指针第一次相遇的结点一定是在环中，
     * 利用环中的节点计算出环的长度n，
     * 回到起点，先让一个指针走n步，然后再同时走，第一次相遇的结点就是环的入口点。
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetNode = meetNode(pHead);
        //1.判断是否有环
        if(meetNode == null){
            return null;
        }
        //2.计算环的长度
        int len = 1;
        ListNode node = meetNode;
        while(node.next != meetNode){
            len++;
            node = node.next;
        }
        //3.定义快慢指针，快指针先走 len 步，然后快慢指针同时走
        ListNode fast = pHead;
        ListNode low = pHead;
        while(len > 0){
            fast = fast.next;
            len--;
        }
        while(low != fast){
            low = low.next;
            fast = fast.next;
        }
        return low;
    }
    //判断环是否存在
    private ListNode meetNode(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode low = pHead.next;
        ListNode fast = low.next;
        while(low != null && fast != null){
            if(low == fast){
                return low;
            }
            low = low.next;
            fast = fast.next;
            if(fast != low){
                fast = fast.next;
            }
        }
        return null;
    }


    //方法1：遍历
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        if(pHead == null){
            return null;
        }
        List<ListNode> list = new LinkedList<>();
        ListNode cur = pHead;
        while(cur != null){
            if(list.contains(cur)){
                return cur;       //遍历到的第一个重复的结点即为环的入口结点
            }
            list.add(cur);
            cur = cur.next;
        }
        return null;   //没有环，返回 null
    }
}
