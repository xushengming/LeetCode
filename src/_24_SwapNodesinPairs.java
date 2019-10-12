public class _24_SwapNodesinPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode first = head, second, lastFirst = null;
        ListNode newHead = null;
        while (first != null){
            second = first.next;
            if(newHead == null){
                newHead = second;
            }
            if(second == null){
                break;
            }
            first.next = second.next;
            second.next = first;
            if(lastFirst != null){
                lastFirst.next = second;
            }
            lastFirst = first;
            first = first.next;
        }
        return newHead;
    }
}
