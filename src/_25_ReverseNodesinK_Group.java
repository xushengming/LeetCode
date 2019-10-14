public class _25_ReverseNodesinK_Group {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseKGroupRecursiveVersion(ListNode head, int k){
        if(head == null || head.next == null || k == 1){
            return head;
        }

        int count = 0;
        ListNode nextGroup = head;
        while (nextGroup != null && count < k){
            count++;
            nextGroup = nextGroup.next;
        }
        if(count == k){
            nextGroup = reverseKGroupRecursiveVersion(nextGroup, k);
            while (count > 0){
                count--;
                ListNode next = head.next;
                head.next = nextGroup;
                nextGroup = head;
                head = next;
            }
            head = nextGroup;
        }
        return head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1){
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode begin = dummyNode;
        int i = 0;
        while (head != null){
            i++;
            if(i % k == 0){
                begin = reverseExclusively(begin, head.next);
                head = begin.next;
            }else{
                head = head.next;
            }
        }
        return dummyNode.next;

    }

    private ListNode reverseExclusively(ListNode begin, ListNode end){
        ListNode current = begin.next;
        ListNode tail = current;
        ListNode next;
        ListNode previous = begin;
        while (current != end){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        begin.next = previous;
        tail.next = end;
        return tail;
    }
}
