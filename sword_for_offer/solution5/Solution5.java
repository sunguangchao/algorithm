package solution5;

import java.util.ArrayList;

/**
 * 面试题5：从头到尾打印链表
 * Created by 11981 on 2018/5/8.
 * 这里主要是采用递归的方法
 */
public class Solution5 {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> printListTailToHead(ListNode listNode){
        if (listNode != null){
            this.printListTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution5 solution5 = new Solution5();
        solution5.printListTailToHead(node1);
    }
}
