public class _19_RemoveNthNodeFromEndofList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHeaderNode = new ListNode(Integer.MIN_VALUE);
        dummyHeaderNode.next = head;
        ListNode firstPointer = dummyHeaderNode;
        ListNode secondFointer = dummyHeaderNode;
        int stepOffset = n;
        while (stepOffset > 0){
            firstPointer = firstPointer.next;
            stepOffset--;
        }
        while (firstPointer.next != null){
            firstPointer = firstPointer.next;
            secondFointer = secondFointer.next;
        }
        ListNode removed = secondFointer.next;
        secondFointer.next = removed.next;
        removed.next = null;
        return dummyHeaderNode.next;
    }
}
