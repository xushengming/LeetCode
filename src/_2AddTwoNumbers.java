public class _2AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode head = null;
        ListNode current = null;
        int increase = 0;
        while (l1 != null && l2 != null){
            ListNode node = null;
            int val = 0;
            val = l1.val + l2.val + increase;
            node = l1;
            if(val > 9){
                increase = 1;
                val = val - 10;
            }else{
                increase = 0;
            }
            node.val = val;
            if(head == null){
                head = node;
                current = head;
            }else {
                current = node;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            current.next = l1;
            current = l1;
            while (increase > 0 && l1 != null){
                int val = l1.val + increase;
                if(val > 9){
                    increase = 1;
                    val = val - 10;
                }else{
                    increase = 0;
                }
                l1.val = val;
                current = l1;
                l1 = l1.next;
            }
        }else if(l2 != null) {
            current.next = l2;
            current = l2;
            while (increase > 0 && l2 != null) {
                int val = l2.val + increase;
                if (val > 9) {
                    increase = 1;
                    val = val - 10;
                } else {
                    increase = 0;
                }
                l2.val = val;
                current = l2;
                l2 = l2.next;
            }
        }
        if (increase > 0) {
            ListNode node = new ListNode(increase);
            current.next = node;
        }
        return head;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = null;
        ListNode current = null;
        int increase = 0;
        while(l1 != null || l2 != null){
            ListNode node = null;
            int val = 0;
            if(l1 != null && l2 != null){
                val = l1.val + l2.val + increase;
                node = l1;
            }else if(l1 == null){
                val = l2.val + increase;
                node = l2;
            }else{
                val = l1.val + increase;
                node = l1;
            }
            if(val > 9){
                increase = 1;
                val = val - 10;
            }else{
                increase = 0;
            }
            node.val = val;
            if(head == null){
                head = node;
                current = head;
            }else {
                current.next = node;
                current = node;
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(increase > 0){
            ListNode node = new ListNode(increase);
            current.next = node;
            current = node;
        }
        return head;
    }
}
