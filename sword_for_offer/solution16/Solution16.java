package solution16;

import solution17.ListNode;


/**
 * Created by 11981 on 2018/5/24.
 */
public class Solution16 {
    public ListNode ReverseList(ListNode head){
        if (head == null){
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;//首先记录当前节点的下一个节点，（保存起来）
            head.next = pre;//让当前节点指向前一个节点，因为要反序嘛
            pre = head;//让前一个节点值，取代当前的节点值。因为要继续向下走
            head = next;//让下一个节点，取代当前节点。同样是向下走，为下一次循环做准备
        }
        return pre;
    }
}
