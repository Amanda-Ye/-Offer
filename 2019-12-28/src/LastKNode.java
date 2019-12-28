/**
 * 14.链表中倒数第K个节点：
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

//！！！代码的鲁棒性（健壮性）
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class LastKNode {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        int count = 0;
        while(cur != null){    //求结点个数
            count++;
            cur = cur.next;
        }
        if(count < k){
            return null;
        }
        cur = head;
        for(int i = 0;i < count -k;i++){   //目标位置是 count - k + 1
            cur = cur.next;
        }
        return cur;
    }

    public ListNode FindKthToTail2(ListNode head,int k){    //代码最少最简洁
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        for(;fast != null;i++){
            if(i >= k){
                slow = slow.next;
            }
            fast = fast.next;
        }
        return i < k ? null : slow;
    }

    public ListNode FindKthToTail3(ListNode head,int k){
        if(head == null || k == 0){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0;i < k;i++){
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
