/**
 * 15.反转链表：（代码的鲁棒性）
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Reverse {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = null;
        ListNode cur = head;
        while(cur != null){
            ListNode node = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = node;
        }
        return newHead;
    }
}
