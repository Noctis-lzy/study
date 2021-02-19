package main.java.mine;

public class MergeTwoLists {

  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode current = listNode;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    current.next = l1;
                    current = current.next;
                    l1 = l1.next;
                }
                else {
                    current.next = l2;
                    current = current.next;
                    l2 = l2.next;
                }
            }
            else if (l1 != null) {
                current.next = l1;
                break;
            }
            else {
                current.next = l2;
                break;
            }
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        mergeTwoLists.mergeTwoLists(l1, l2);
    }
}
