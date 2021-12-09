//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1550 👎 0

  
package leetcode.editor.cn;

/**
 * @author yinyg
 * @date 2021-09-08 09:44:17
 * @description 19.删除链表的倒数第 N 个结点
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        // 方法1 记录倒数第n个节点的前缀节节点
//        ListNode tmp = new ListNode();
//        tmp.next = head;
//        ListNode rp = tmp;
//        int num = 1;
//        while (head.next != null) {
//            head = head.next;
//            if (num == n) {
//                rp = rp.next;
//                continue;
//            }
//            num++;
//        }
//        rp.next = rp.next.next;
//        return tmp.next;


//        // 方法2 快慢指针
//        ListNode slow = head;
//        ListNode fast = head;
//        int length = 1;
//        int slowIndex = 0;
//        while (fast.next != null && fast.next.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//            length += 2;
//            slowIndex++;
//        }
//        if (fast.next != null) {
//            length += 1;
//        }
//        int index = length - n;
//        if (index == 0) {
//            return head.next;
//        }
//        if (slowIndex >= index) {
//            slow = head;
//            slowIndex = 0;
//        }
//        while (slowIndex < index - 1) {
//            slow = slow.next;
//            slowIndex++;
//        }
//        slow.next = slow.next.next;
//        return head;


        // 方法3 双指针
        ListNode tmp = new ListNode(0, head);
        ListNode first = tmp;
        ListNode second = tmp;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return tmp.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
