package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhanghaibing
 * @date 2024-02-12
 */
public class Longest {

/**
 * leetcode 3 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 思想：这个算法主要是维护一个滑动窗口，窗口内的所有字符都是不重复的。当遇到重复的字符时，缩小
 * 窗口的左边界直到重复字符移出窗口，然后继续向右扩展窗口并更新最大长度。这样可以遍历一次字符串
 * 的前提下找到无重复的最大长串
 */
    public static void main(String[] args) {
        Longest longest = new Longest();
        System.out.println(longest.longestSub("abcabcbb"));
        System.out.println(longest.longestSub("bbbbb"));
        System.out.println(longest.longestSub("pwwkew"));
        System.out.println(longest.longestSub(" "));
        System.out.println(longest.longestSub(" "));
    }

    public int longestSub(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        // 存储不重复的字符串
        Set<Character> sets = new HashSet();
        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while(sets.contains(c)) {
                sets.remove(c);
                left++;
            }

            sets.add(c);
            maxLen = Math.max(maxLen, right - left + 1);

        }

        return maxLen;
    }

































}
