package DataStructerAndAlgo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yinyg
 * @date 2021/8/1
 * @description 字符串匹配算法
 * 1、BM算法
 * 2、KMP算法
 */
public class StringMatchUtil {

    private static final int SIZE = 256;

    /** patterns for AC */
    private String[] patterns = new String[] {"c", "bc", "bcd", "abcd"};

    /** Trie for AC */
    private AcNode root;

    public StringMatchUtil() {
        this.root = new AcNode('/');
        buildTrie();
        buildFailurePoint();
    }

    private void buildTrie() {
        if (this.patterns == null || this.patterns.length == 0) {
            return;
        }
        char[] pattern;
        AcNode node;
        int size = this.patterns.length;
        AcNode root = this.root;
        for (int i = 0; i < size; i++) {
            node = root;
            pattern = this.patterns[i].toCharArray();
            int length = pattern.length;
            for (int j = 0; j < length; j++) {
                int index = pattern[j] - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new AcNode(pattern[j]);
                }
                node = node.children[index];
                if (j == length - 1) {
                    node.isEndingChar = true;
                    node.length = length;
                }
            }
        }
    }

    private void buildFailurePoint() {
        Queue<AcNode> queue = new LinkedList<>();
        AcNode root = this.root;
        root.fail = null;
        queue.add(root);
        AcNode p, pc, q, qc;
        while (!queue.isEmpty()) {
            p = queue.remove();
            for (int i = 0; i < 26; i++) {
                pc = p.children[i];
                if (pc == null) {
                    continue;
                }
                if (p == root) {
                    pc.fail = root;
                } else {
                    q = p.fail;
                    while (q != null) {
                        qc = q.children[p.data - 'a'];
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    /**
     * @param source
     * @param pattern
     * @return int
     * @throws
     * @description BM算法
     * 1、将模式串与主串首位对齐，开始匹配
     * 2、从模式串最后一位字符开始匹配，当主串完全匹配模式串时，返回模式串第一个字符对应主串的下标，当遇到不匹配的字符
     * 3、利用 坏字符规则 计算模式串移动的位数
     * 4、利用 好后缀规则 计算模式串移动的位数
     * 5、取2种规则移动位数大的，作为模式串的移动位数，移动模式串，回到步骤2
     * @author yinyg
     * @date 2021/8/1
     */
    public int bm(String source, String pattern) {
        if (source == null) {
            throw new NullPointerException("source can not be null");
        }
        if (pattern == null) {
            throw new NullPointerException("pattern can not be null");
        }

        int sourceLength = source.length();
        int patternLength = pattern.length();
        if (sourceLength < patternLength) {
            return -1;
        }

        int[] patternCharIndex = new int[SIZE];
        char[] patternChars = pattern.toCharArray();
        generateCharIndex(patternChars, patternCharIndex);

        int[] suffix = new int[patternLength];
        boolean[] prefix = new boolean[patternLength];
        generateSuffix(patternChars, suffix, prefix);

        int badCharOffset;
        int goodSuffixOffset = -1;
        int i = 0;
        int j, k;
        while (i <= sourceLength - patternLength) {
            for (j = patternLength - 1; j >= 0; j--) {
                if (source.charAt(i + j) != patternChars[j]) {
                    break;
                }
            }
            if (j < 0) {
                return i;
            }
            badCharOffset = j - patternCharIndex[(int)patternChars[j]];
            k = patternLength - 1 - j;
            if (suffix[k] != -1) {
                goodSuffixOffset = j - suffix[k] + 1;
            } else {
                k -= 1;
                while (k > 0) {
                    if (prefix[k]) {
                        goodSuffixOffset = patternLength - k;
                    }
                    k--;
                }
            }
            i += Math.max(badCharOffset, goodSuffixOffset);
        }

        return -1;
    }

    private void generateCharIndex(char[] chars, int[] charIndex) {
        for (int i = 0 ; i < SIZE; i++) {
            charIndex[i] = -1;
        }
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            int index = (int)chars[i];
            charIndex[index] = i;
        }
    }

    private void generateSuffix(char[] chars, int[] suffix, boolean[] prefix) {
        int length = chars.length;

        for (int i = 0; i < length; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }

        int l;
        for (int i = 0; i < length - 1; i++) {
            l = 0;
            while (l <= i && chars[i - l] == chars[length - 1 - l]) {
                l++;
                suffix[l] = i - l;
            }
            if (l == i + 1) {
                prefix[l] = true;
            }
        }
    }

    /**
     * @param source
     * @param pattern
     * @return int
     * @throws
     * @description KMP算法
     * 1、将模式串与主串首位对齐，开始匹配
     * 2、从模式串第一位字符开始匹配，当主串完全匹配模式串时，返回模式串第一个字符对应主串的下标，当遇到不匹配的字符
     * 3、当前已匹配的字符串，叫做好前缀，找到最长匹配前缀子串，根据最长匹配前缀子串最后一个字符的下标，移动模式串
     * 4、回到步骤2
     * @author yinyg
     * @date 2021/8/8
     */
    public int kmp(String source, String pattern) {
        if (source == null) {
            throw new NullPointerException("source can not be null");
        }
        if (pattern == null) {
            throw new NullPointerException("pattern can not be null");
        }

        int sourceLength = source.length();
        int patternLength = pattern.length();
        if (sourceLength < patternLength) {
            return -1;
        }

        int[] next = new int[patternLength];
        char[] patternChars = pattern.toCharArray();
        generateNext(patternChars, next);

        int j = 0;
        for (int i = 0; i < sourceLength; i++) {
            while (j > 0 && source.charAt(i) != patternChars[j]) {
                j = next[j - 1] + 1;
            }
            if (source.charAt(i) == patternChars[j]) {
                j++;
            }
            if (j == patternLength) {
                return i - patternLength + 1;
            }
        }
        return -1;
    }

    private void generateNext(char[] s, int[] next) {
        next[0] = -1;
        int k = -1;
        int length = s.length;
        for (int i = 1; i < length; i++) {
            while (k > -1 && s[k + 1] != s[i]) {
                k = next[k];
            }
            if (s[k + 1] == s[i]) {
                k++;
            }
            next[i] = k;
        }
    }

    /**
     * @param source
     * @return int[]
     * @throws
     * @description AC自动机
     * 1、构建Trie树
     * 2、在Trie树上构建失败指针
     * 3、遍历，查找所有模式串
     * @author yinyg
     * @date 2021/8/19
     */
    public int[] ac(String source) {
        if (source == null) {
            throw new NullPointerException("source can not be null");
        }

        char[] sourceArray = source.toCharArray();
        int length = sourceArray.length;
        AcNode root = this.root;
        AcNode p = root;
        AcNode tmp;
        int index;
        for (int i = 0; i < length; i++) {
            index = sourceArray[i] - 'a';
            while (p.children[index] == null && p != root) {
                p = p.fail;
            }
            p = p.children[index];
            if (p == null) {
                p = root;
            }
            tmp = p;
            while (tmp != root) {
                if (tmp.isEndingChar) {
                    System.out.println("下标: " + (i - tmp.length + 1) + "，长度: " + tmp.length);
                }
                tmp = tmp.fail;
            }
        }

        return null;
    }


    private class AcNode {
        public char data;
        public AcNode[] children = new AcNode[26]; // 字符集只包含a~z这26个字符
        public boolean isEndingChar = false; // 结尾字符为true
        public int length = -1; // 当isEndingChar=true时，记录模式串长度
        public AcNode fail; // 失败指针
        public AcNode(char data) {
            this.data = data;
        }
    }

}
