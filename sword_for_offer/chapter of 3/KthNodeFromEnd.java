/**
 * Created by 11981 on 2017/3/25.
 * 面试题15：链表中倒数第k个结点
 * 思路：采用两个指针的方法，第一个先走k步之后，另一个开始走
 * 这样，当第一个到达尾结点后，另一个的位置就是所要找的位置
 * 还需要考虑三种异常情况
 * 时间复杂度：O(n)，而且只需遍历链表一次
 */
public class KthNodeFromEnd {
    public static void main(String[] args){
        ListNode2 head=new ListNode2();
        ListNode2 second=new ListNode2();
        ListNode2 third=new ListNode2();
        ListNode2 forth=new ListNode2();
        head.nextNode=second;
        second.nextNode=third;
        third.nextNode=forth;
        head.data=1;
        second.data=2;
        third.data=3;
        forth.data=4;
        KthNodeFromEnd k=new KthNodeFromEnd();
        ListNode2 resultListNode=k.findKthNodeFromEnd(head, 3);
        System.out.println(resultListNode.data);
    }
    public ListNode2 findKthNodeFromEnd(ListNode2 head, int k){
        if (head == null || k == 0) {
            return null;
        }
        ListNode2 resultNode = null;
        ListNode2 headNode = head;
        for (int i=0; i < k; i++){
            if (headNode.nextNode != null){
                headNode = headNode.nextNode;
            }else{
                return null;
            }
        }
        resultNode = head;
        while (headNode != null){
            resultNode = resultNode.nextNode;
            headNode = headNode.nextNode;
        }
        return resultNode;
    }
}
class ListNode2{
    int data;
    ListNode2 nextNode;
}