import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinyg
 * @date 2023/10/18
 */
class Solution {

    private List<String> list = new ArrayList<>(10);

    public List<String> restoreIpAddresses(String s) {
        if (s != null && s.length() >= 4) {
            restoreIpAddresses(s, s.length(), "", 0, 0);
        }
        return list;
    }

    // s: 原始字符串，length: 原始字符串的长度，cur: 当前字符串，pos: 当前遍历到原始字符串的位置，i: 当前是ip地址的第几个段
    private void restoreIpAddresses(String s, int length, String cur, int pos, int i) {
        if (pos >= length) {
            return;
        }
        if (i == 3) {
            String str = s.substring(pos, length);
            if (check(str)) {
                list.add(cur + "." + str);
            }
            return;
        }
        for (int j = 0; j < 3 && pos + j < length; j++) {
            String str = s.substring(pos, pos + j + 1);
            if (!check(str)) {
                break;
            }
            if (i == 0) {
                restoreIpAddresses(s, length, str, pos + j + 1, i + 1);
            } else {
                restoreIpAddresses(s, length, cur + "." + str, pos + j + 1, i + 1);
            }
        }
    }

    private boolean check(String str) {
        if (str.length() > 3) {
            return false;
        }
        if (str.length() > 1 && str.charAt(0) == '0') {
            return false;
        }
        int num = Integer.valueOf(str);
        if (num > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Solution().restoreIpAddresses("25525511135")));
    }

}
