package solution17;

/**
 * Created by 11981 on 2018/5/24.
 * 面试题17：合并两个排序的链表
 * 主要思想：递归，注意考虑边界条件
 */
public class Solution17 {
    public ListNode Merge(ListNode list1, ListNode list2){
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

}
