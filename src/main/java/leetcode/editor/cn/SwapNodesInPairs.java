//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 1040 👎 0

  
package leetcode.editor.cn;

/**
 * @author yinyg
 * @date 2021-09-13 17:16:52
 * @description 24.两两交换链表中的节点
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
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
    public ListNode swapPairs(ListNode head) {
//        // 方法1
//        if (head == null) {
//            return null;
//        }
//        ListNode tmp = new ListNode(0, head);
//        ListNode node = head;
//        ListNode pre = tmp;
//        while (node != null && node.next != null) {
//            pre.next = node.next;
//            node.next = node.next.next;
//            pre.next.next = node;
//            pre = node;
//            node = node.next;
//        }
//        return tmp.next;

        // 方法2 优化
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(0, head);
        ListNode pre = result;
        ListNode node1, node2;
        while (pre.next != null && pre.next.next != null) {
            node1 = pre.next;
            node2 = pre.next.next;
            pre.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            pre = node1;
        }
        return result.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
