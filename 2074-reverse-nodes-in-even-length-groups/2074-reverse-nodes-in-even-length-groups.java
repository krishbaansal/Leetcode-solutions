/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int groupSize = 1;

        while (prev.next != null) {
            ListNode curr = prev.next;
            int count = 0;

            while (count < groupSize && curr != null) {
                curr = curr.next;
                count++;
            }

            if (count % 2 == 0) {
                ListNode groupPrev = curr;
                ListNode node = prev.next;

                for (int i = 0; i < count; i++) {
                    ListNode next = node.next;
                    node.next = groupPrev;
                    groupPrev = node;
                    node = next;
                }

                ListNode tail = prev.next;
                prev.next = groupPrev;
                prev = tail;
            } else {
                for (int i = 0; i < count; i++) {
                    prev = prev.next;
                }
            }

            groupSize++;
        }

        return dummy.next;
    }
}