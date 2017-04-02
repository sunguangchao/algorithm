

/**
 * Created by 11981 on 2017/3/25.
 */
public class DeleteNodeInList {
    public static void main(String[] args){
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        head.nextNode = second;
        second.nextNode = third;
        head.date = 1;
        second.date = 2;
        third.date = 3;
        DeleteNodeInList d = new DeleteNodeInList();
        d.deleteNode(head,second);
        System.out.println(head.nextNode.date);

    }
    public void deleteNode(ListNode head, ListNode deListNode){
        if (deListNode == null || head == null)//如果链表为空
            return;
        if (head == deListNode){//如果链表中只有一个结点
            head = null;
        }else{
            if (deListNode.nextNode == null){//如果要删除的结点在尾结点
                ListNode pointListNode = head;
                //需要从头结点开始便遍历，删除尾结点（将尾结点置为空）
                //复杂度为O(n)
                while (pointListNode.nextNode.nextNode != null){
                    pointListNode=pointListNode.nextNode;
                }
                pointListNode.nextNode = null;
            }else{//如果要删除的节点不在尾结点，可以将要删除后的结点的值直接覆盖，并将指针指向下下结点
                deListNode.date = deListNode.nextNode.date;
                deListNode.nextNode = deListNode.nextNode.nextNode;
            }
        }
    }
}
class ListNode{
    int date;
    ListNode nextNode;
}
