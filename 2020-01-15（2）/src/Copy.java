/**
 * 25.复杂链表的复制：
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Copy {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null){
            return null;
        }
        RandomListNode cur = pHead;
        //复制结点及 next 指针内容
        while(cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            RandomListNode next = cur.next;
            node.next = cur.next;
            cur.next = node;
            cur = next;
        }
        //复制 random 指针内容
        cur = pHead;
        while(cur != null){
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        //拆分
        cur = pHead;
         RandomListNode newHead = pHead.next;
        while(cur != null){
            RandomListNode node = cur.next;
            cur.next = node.next;
            node.next = node.next == null ? null : node.next.next;
            cur = cur.next;
        }
       return newHead;
    }
}
