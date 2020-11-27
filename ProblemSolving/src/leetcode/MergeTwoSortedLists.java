package leetcode;

import java.util.List;

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// reference: https://www.programcreek.com/2012/12/leetcode-merge-two-sorted-lists-java/
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = head;

        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;    // link current node to smaller node(p1)
                p1 = p1.next;   // p1 move to next node
            } else {
                p.next = p2;    // link current node to smaller node(p2)
                p2 = p2.next;   // p2 move to next node
            }
            p = p.next;         // current node move to next node(p)
        }

        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        return head.next; // because head has empty instance of ListNode
    }

    public static void main(String[] args) {

        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(4);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        ListNode head = (mergeTwoLists(l1_1, l2_1));

        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
