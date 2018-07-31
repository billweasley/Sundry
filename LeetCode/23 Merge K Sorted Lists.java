/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node: lists){
            if (node != null) queue.add(node);
        }
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        ListNode current = head;
        while(queue.size() > 0){
            prev = current;
            current = queue.poll();
            prev.next = current;
            if(current.next != null) queue.add(current.next);
        }
        return head.next;
    }*/

    public ListNode mergeKLists(ListNode[] lists) {
        return (lists.length == 0)? null : divideAndConquer(lists, 0, lists.length - 1);
    }

    private ListNode divideAndConquer(ListNode[] lists, int left, int right){
        if (left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode firstPart = divideAndConquer(lists, left, mid);
        ListNode secondPart = divideAndConquer(lists, mid + 1, right);
        return mergeTwo(firstPart, secondPart);
    }

    private ListNode mergeTwo(ListNode a, ListNode b){
        if (a == null) return b;
        if (b == null) return a;
        if (a.val < b.val){
            a.next = mergeTwo(a.next, b);
            return a;
        }else{
            b.next = mergeTwo(a, b.next);
            return b;
        }
    }


}