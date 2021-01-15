package main.java.mine;
/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例 1：

 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * */
public class AddTwoNumbers {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        while (true) {
            sb1.insert(0, l1.val);
            l1 = l1.next;
            if (l1 == null) {
                break;
            }
            if (l1.next == null) {
                sb1.insert(0, l1.val);
                break;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            sb2.insert(0, l2.val);
            l2 = l2.next;
            if (l2 == null) {
                break;
            }
            if (l2.next == null) {
                sb2.insert(0, l2.val);
                break;
            }
        }
        String num = String.valueOf(Long.parseLong(sb1.toString()) + Long.parseLong(sb2.toString()));

        ListNode fatherNode = new ListNode();
        if (num.length() > 1) {
            for (int i = 0; i < num.length() - 1; ++i) {
                int value = Integer.parseInt(String.valueOf(num.charAt(i)));
                if (fatherNode.next == null) {
                    fatherNode.val = value;
                    }
                fatherNode = new ListNode(Integer.parseInt(String.valueOf(num.charAt(i + 1))), fatherNode);

            }
        }
        if (num.length() == 1) {
            fatherNode = new ListNode(Integer.parseInt(String.valueOf(num.charAt(0))));
        }
        return fatherNode;

    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        addTwoNumbers(l11, l21);
    }
}
