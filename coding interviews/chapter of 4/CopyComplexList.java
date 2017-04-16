/**
 * Created by 11981 on 2017/4/14.
 * 面试题26：复杂链表的复制
 */
public class CopyComplexList {
    public static void main(String[] args){
        CopyComplexList c = new CopyComplexList();
        ComplexListNode root=new ComplexListNode();
        ComplexListNode node1=new ComplexListNode();
        ComplexListNode node2=new ComplexListNode();
        ComplexListNode node3=new ComplexListNode();
        ComplexListNode node4=new ComplexListNode();
        root.data=1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        root.data=1;
        node1.data=2;
        node2.data=3;
        node3.data=4;
        node4.data=5;
        root.sibling=node1;
        node1.sibling=root;
        node3.sibling=node1;
        ComplexListNode result = c.clone(root);
        System.out.println(result.data);

    }
    public ComplexListNode clone(ComplexListNode head){

        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }

    //复制原始链表的任意结点tmpNode并创建新节点cloneNode，再把cloneNode
    //链接到tmpNode的后面
    public void cloneNodes(ComplexListNode head){
        ComplexListNode tmpNode = head;
        while (tmpNode != null) {
            ComplexListNode cloneNode = new ComplexListNode();
            cloneNode.data = tmpNode.data;
            cloneNode.next = tmpNode.next;
            cloneNode.sibling = null;

            tmpNode.next = cloneNode;
            tmpNode = cloneNode.next;   //执行下一个结点
        }
    }

    //设置cloneNode的sibling
    public void connectSiblingNodes(ComplexListNode head){
        ComplexListNode tmpNode = head;
        while (tmpNode != null){
            ComplexListNode cloneNode = tmpNode.next;
            if (tmpNode.sibling != null) {
                cloneNode.sibling = tmpNode.sibling.next;
            }
            tmpNode = cloneNode.next;
        }
    }

    //长链表拆分成两个链表
    public ComplexListNode reconnectNodes(ComplexListNode head){
        ComplexListNode tmpNode = head;
        ComplexListNode cloneHead = null;
        ComplexListNode cloneNode = null;

        if (tmpNode != null) {
            cloneNode = tmpNode.next;
            cloneHead = cloneNode;
            tmpNode.next = cloneNode.next;
            tmpNode = tmpNode.next;
        }

        while (tmpNode != null){
            cloneNode.next = tmpNode.next;
            cloneNode = cloneHead.next;
            tmpNode.next = cloneNode.next;
            tmpNode = tmpNode.next;
        }
        return cloneHead;
    }
}

class ComplexListNode{
    int data;
    ComplexListNode next;     //指向下一个结点
    ComplexListNode sibling;  //指向任意结点或者是null
}


