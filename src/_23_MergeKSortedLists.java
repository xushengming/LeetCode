public class _23_MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        ListNode[] tmpLists = new ListNode[lists.length + 1];
        tmpLists[0] = null;
        for (int i = 0; i < lists.length; i++){
            tmpLists[i + 1] = lists[i];
        }
        int n = tmpLists.length - 1;
        for(int i = n / 2; i >= 1; i--){
            sink(tmpLists, i, n);
        }
        ListNode head = null;
        ListNode current = null;
        while (tmpLists[1] != null){
            if(head == null){
                head = tmpLists[1];
                current = tmpLists[1];
            }else{
                current.next = tmpLists[1];
                current = tmpLists[1];
            }
            tmpLists[1] = tmpLists[1].next;
            sink(tmpLists, 1, n);
        }
        return head;
    }

    private void sink(ListNode[] array, int start, int n){
        while (2 * start <= n){
            int childMin = 2 * start;
            if(childMin + 1 <= n && moreThan(array, childMin, childMin + 1)){
                childMin++;
            }
            if(moreThan(array, start, childMin)){
                swap(array, start, childMin);
                start = childMin;
            }else{
                break;
            }
        }
    }

    private boolean moreThan(ListNode[] array, int left, int right){
        return array[left] == null
                || (array[right] != null
                && array[left].val > array[right].val);
    }

    private void swap(ListNode[] array, int i, int j){
        ListNode tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
