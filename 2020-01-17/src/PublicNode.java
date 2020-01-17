/**
 * 36.两个链表的第一个公共结点：
 * 输入两个链表，找出它们的第一个公共结点。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class PublicNode {
    /**
     * 题解：
     * 解调思路：那就是遍历两遍这两个链表，如果有重复的节点，那么一定能够使遍历的指针相等。
     * 如果有公共结点，那么指针一起走到末尾的部分，也就一定会重叠。看看下面指针的路径吧。
     * p1： 0-1-2-3-4-5-null(此时遇到ifelse)-a-b-4-5-null
     * p2: a-b-4-5-null(此时遇到ifelse)0-1-2-3-4-5-null
     * 因此，两个指针所要遍历的链表就长度一样了！
     * 如果两个链表存在公共结点，那么p1就是该结点，如果不存在那么p1将会是null。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
            if(cur1 != cur2){
                if(cur1 == null) cur1 = pHead2;
                if(cur2 == null) cur2 = pHead1;
            }
        }
        return cur1;
    }

    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        while(cur1 != null){          //嵌套循环，时间复杂度大
            ListNode cur2 = pHead2;
            while(cur2 != null){
                if(cur1 == cur2){
                    return cur1;
                }
                cur2 = cur2.next;
            }
            cur1 = cur1.next;
        }
        return null;
    }

    public ListNode FindFirstCommonNode0(ListNode pHead1, ListNode pHead2) {  //运行不通过
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while(cur1 != null && cur2 != null){
            if(cur1 == cur2){
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }
}
