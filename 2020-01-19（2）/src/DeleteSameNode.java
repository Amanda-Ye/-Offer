import java.util.ArrayList;
import java.util.List;

/**
 * 56.删除链表中重复的结点：
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

public class DeleteSameNode {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.next != null && cur.next.val == cur.val){
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }

    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode newHead = new ListNode(-1);
        ListNode last = newHead;
        ListNode cur = pHead;
        while(cur != null){
            ListNode node = cur.next;
            boolean flag = false;
            while(node != null && cur.val == node.val){
                node = node.next;
                flag = true;
            }
            if(!flag){
                last.next = cur;
                last = cur;
            }
            cur = node;
        }
        last.next = null;
        return newHead.next;
    }
}
