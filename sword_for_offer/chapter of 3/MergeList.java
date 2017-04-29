/**
 * Created by 11981 on 2017/4/1.
 * 面试题17：合并两个排序的链表
 * 思路：使用两个链表的头结点的值进行比较，
 * 哪个小就放入合并的链表中，然后用递归
 */
public class MergeList {
    public static void main(String[] args){
        ListNode head1=new ListNode();
        ListNode second1=new ListNode();
        ListNode head2=new ListNode();
        ListNode second2=new ListNode();
        ListNode third2=new ListNode();
        head1.nextNode=second1;
        head2.nextNode=second2;
        second2.nextNode=third2;
        head1.date=1;
        second1.date=3;
        head2.date=2;
        second2.date=2;
        third2.date=2;
        MergeList test=new MergeList();
        ListNode result=test.mergeList(head1, head2);
        System.out.println(result.nextNode.nextNode.nextNode.nextNode.date);
    }
    public ListNode mergeList(ListNode head1, ListNode head2){
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        ListNode mergeListNode = null;
        if (head1.date < head2.date){
            mergeListNode = head1;
            mergeListNode.nextNode = mergeList(head1.nextNode, head2);
        }else{
            mergeListNode = head2;
            mergeListNode.nextNode = mergeList(head1, head2.nextNode);
        }
        return mergeListNode;
    }
}
