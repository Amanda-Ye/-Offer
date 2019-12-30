/**
 * 16.合并两个排序的链表：（代码的鲁棒性）
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 ==null && list2 == null){
            return null;
        }
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode last = head;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                last.next = cur1;
                last = cur1;
                cur1 = cur1.next;
            }else{
                last.next = cur2;
                last = cur2;
                cur2 = cur2.next;
            }
        }
        if(cur1 != null){
            last.next = cur1;
        }
        if(cur2 != null){
            last.next = cur2;
        }
        return head.next;
    }

    public ListNode Merge1(ListNode list1,ListNode list2){
        if(list1 ==null && list2 == null){
            return null;
        }
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode last = head;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while(cur1 != null || cur2 != null){
            if(cur1 == null){
                last.next = cur2;
                break;
            }
            if(cur2 == null){
                last.next = cur1;
                break;
            }
            if(cur1.val <= cur2.val){
                last.next = cur1;
                last = cur1;
                cur1 = cur1.next;
            }else{
                last.next = cur2;
                last = cur2;
                cur2 = cur2.next;
            }
        }
        return head.next;
    }
}
