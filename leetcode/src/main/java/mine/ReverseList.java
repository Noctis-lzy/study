package main.java.mine;

public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new ListNode(head.val);
        }
        ListNode rtn = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = rtn;
            rtn = head;
            head = next;
        }

        return rtn;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        ReverseList reverseList = new ReverseList();
        reverseList.reverseList(listNode);
    }
}
