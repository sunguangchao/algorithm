
/**
 * Created by 11981 on 2017/4/1.
 * 面试题16：反转链表
 * 思路：使用三个指针，分别指向当前遍历到的结点、
 * 它的前结点以及后一个结点。
 *
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        ListNode forth = new ListNode();
        head.nextNode = second;
        second.nextNode = third;
        third.nextNode = forth;
        head.date = 1;
        second.date = 2;
        third.date = 3;
        forth.date = 4;
        ReverseList test = new ReverseList();
        ListNode resultListNode = test.reverseList(head);
        System.out.println(resultListNode.date);
    }
    public ListNode reverseList(ListNode head){
        if (head == null)//当链表为空时
            return null;
        if (head.nextNode == null)//当链表只有一个结点时
            return null;

        ListNode reversedHead = null;
        ListNode nowListNode = head;
        ListNode preListNode = null;
        while (nowListNode != null){
            ListNode nextListNode = nowListNode.nextNode;
            if (nextListNode == null){
                reversedHead = nowListNode;
            }
            nowListNode.nextNode = preListNode;

            //为下一次循环做准备，当前结点作为前结点，next结点为当前结点。
            preListNode = nowListNode;
            nowListNode = nextListNode;
        }
        return reversedHead;
    }
}
