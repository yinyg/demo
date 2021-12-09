//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 5677 👎 0

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yinyg
 * @date 2021-07-01 22:17:57
 * @description 3.无重复字符的最长子串
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        int result = 0;
//        Integer integer = null;
//        int start = 0;
//        for (int i = 0; i < s.length(); i++) {
//            integer = map.get(s.charAt(i));
//            if (integer != null && integer >= start) {
//                start = integer + 1;
//            }
//            map.put(s.charAt(i), i);
//            result = Math.max(result, i - start + 1);
//        }
//        return result;

        // 方法2
        int result = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right < length && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            result = Math.max(result, right - i);
            if (right >= length) {
                break;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
