//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1766 👎 0

  
package leetcode.editor.cn;

/**
 * @author yinyg
 * @date 2021-09-05 15:36:22
 * @description 14.最长公共前缀
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
//        // 方法一
//        int strsLen = strs.length;
//        int length0 = strs[0] == null ? 0 : strs[0].length();
//        char c;
//        boolean flag = true;
//        int length = 0;
//        for (int i = 0; i < length0; i++) {
//            c = strs[0].charAt(i);
//            for (int j = 0; j < strsLen; j++) {
//                if (strs[j].length() == length || c != strs[j].charAt(i)) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (!flag) {
//                break;
//            }
//            length++;
//        }
//        if (length > 0) {
//            return strs[0].substring(0, length);
//        }
//        return "";

        // 方法二(优化)
        int strsLen = strs.length;
        int length0 = strs[0] == null ? 0 : strs[0].length();
        char c;
        for (int i = 0; i < length0; i++) {
            c = strs[0].charAt(i);
            for (int j = 1; j < strsLen; j++) {
                if (strs[j].length() == i || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
