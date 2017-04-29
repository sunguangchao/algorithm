/**
 * Created by 11981 on 2017/4/29.
 * 面试题37：两个链表的第一个公共结点
 */
public class FirstCommonNodesInLists {
    public static void main(String[] args){
        ListNode head1=new ListNode();
        ListNode second1=new ListNode();
        ListNode third1=new ListNode();
        ListNode forth1=new ListNode();
        ListNode fifth1=new ListNode();
        ListNode head2=new ListNode();
        ListNode second2=new ListNode();
        head1.next=second1;
        second1.next=third1;
        third1.next=forth1;
        forth1.next=fifth1;
        head2.next=second2;
        second2.next=forth1;
        head1.data=1;
        second1.data=2;
        third1.data=3;
        forth1.data=6;
        fifth1.data=7;
        head2.data=4;
        second2.data=5;
        FirstCommonNodesInLists test = new FirstCommonNodesInLists();

        int result = test.findFirstCommonNode(head1, head2).data;
        System.out.print(result);
    }
    public ListNode findFirstCommonNode(ListNode head1, ListNode head2){

        int len1 = getListLength(head1);
        int len2 = getListLength(head2);
        int diff = 0;
        ListNode longListNode = null;
        ListNode shortListNode = null;
        if (len1 > len2){
            longListNode = head1;
            shortListNode = head2;
            diff = len1 - len2;

        }else{
            longListNode = head2;
            shortListNode = head1;
            diff = len2 - len1;
        }
        for (int i=0; i < diff; i++){
            longListNode = longListNode.next;
        }
        while (longListNode != null && shortListNode != null
                &&longListNode != shortListNode){
            longListNode = longListNode.next;
            shortListNode = shortListNode.next;
        }
        return longListNode;


    }
    private int getListLength(ListNode head){
        int count = 0;
        if (head == null)
            return 0;
        ListNode point = head;
        while (point != null){
            point = point.next;
            count++;
        }
        return count;
    }
}
class ListNode{
    ListNode next;
    int data;
}