//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 
// 👍 1498 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author yinyg
 * @date 2021-09-08 17:21:19
 * @description 23.合并K个升序链表
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }

    public class ListNode {
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

    class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return Integer.compare(o1.val, o2.val);
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
//        // 方法一：顺序合并
//        if (lists == null || lists.length == 0) {
//            return  null;
//        }
//        ListNode pre = new ListNode();
//        pre.next = lists[0];
//        ListNode node, node1, node2;
//        int length = lists.length;
//        for (int i = 1; i < length; i++) {
//            node = pre;
//            node1 = pre.next;
//            node2 = lists[i];
//            while (node1 != null && node2 != null) {
//                if (node1.val <= node2.val) {
//                    node.next = node1;
//                    node1 = node1.next;
//                } else {
//                    node.next = node2;
//                    node2 = node2.next;
//                }
//                node = node.next;
//            }
//            node.next = node1 != null ? node1 : node2;
//        }
//        return pre.next;

        // 方法三：使用优先队列合并，时间复杂度O(kn×logk)，空间复杂度O(k)
        if (lists == null || lists.length == 0) {
            return  null;
        }
        Queue<ListNode> priorityQueue = new PriorityQueue<ListNode>(new ListNodeComparator());
        int length = lists.length;
        for (int i = 0; i < length; i++) {
            if (lists[i] != null) {
                priorityQueue.offer(lists[i]);
            }
        }
        ListNode pre = new ListNode();
        ListNode node = pre;
        ListNode first;
        while (!priorityQueue.isEmpty()) {
            first = priorityQueue.poll();
            node.next  = first;
            node = node.next;
            if (first.next != null) {
                priorityQueue.offer(first.next);
            }
        }
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
