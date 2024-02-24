package chapter_array_and_linkedlist;

/**
 * @author zhanghaibing
 * @date 2024-02-22
 */

import java.util.*;


public class LongestConsecutive {
    /**
     * 思路一：时间复杂度O(n)
     * 1. 将数组中所有整数添加到hashset中用以实现快速查找。
     * 2. 遍历哈希表中的每个整数，如果当前整数前一个数不在集合中，从该数开始，逐步检查后一个整数是否在集合内，累加当前连续序列的长度。
     * 3. 如果当前整数后一个数不在集合中，说明当前连续序列结束，更新最长连续序列长度。
     *
     * 思路二：哈希+双指针(不建议)
     * 1. 初始化哈希表用于存储数组元素及其下标。
     * 2. 初始化两个变量start和max_len分别表示当前连续序列的起始索引和最长连续索引的长度
     * 3. 遍历数组：
     * - 如果当前元素已经存在于哈希表中，则更新start为哈希表中该元素的下一个元素索引，继续遍历数组。
     * - 如果当前元素不在哈希表中，将当前元素及其索引加入到哈希表中，并计算当前连续序列的长度（current_len=index-start+1）
     * - 比较current_len和max_len,如果前者更大，刚更新max_len.
     *
     * 易错点：
     * 1. 如果使用map，对于重复元素的处理比较麻烦，最好使用set.
     *
     * @param nums
     * @return
     */
    public int longestConsecutivex(int[] nums) {
        // 存储整数，方便查询
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        // 记录连续序列最大长度
        int longestStreak = 0;

        for (int num : num_set) {
            // 如果前一个数不在集合中，说明当前连续序列开始
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 遍历当前的连续序列
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public int longestConsecutive(int[] nums) {
        int maxStreak = 0;

        if(nums == null || nums.length == 0) {
            return 0;
        }

        // 用哈希表存储整数，方便快速查询
        Set<Integer> sets = new HashSet();
        for(int num : nums) {
            sets.add(num);
        }

        for(int num : sets) {
            // 如果前一个数不在集合中，则新的连续序列开始
            if(!sets.contains(num - 1)) {
                int curr = num;
                int currStreak = 1;  // 当前长度

                while(sets.contains(curr + 1)) {
                    curr += 1;
                    currStreak = currStreak + 1;
                }
                maxStreak = Math.max(maxStreak, currStreak);
            }
        }
        return maxStreak;
    }

}
















