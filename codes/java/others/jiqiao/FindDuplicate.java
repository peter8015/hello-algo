package others.jiqiao;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhanghaibing
 * @date 2024-02-27
 */
public class FindDuplicate {
    /**
     * 287. 寻找重复数
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
     * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
     *
     * 解法一：floyd判圈法 时间复杂度为O(n)  最优解法
     * 1. 设定两个指针，一个快指针，一个慢指针，都指向数组的第一个元素。
     * 2. 移动快慢指针，直到两个指针相遇，记录下相遇的位置。
     * 3. 将慢指针重量到数组开头，两个指针一起移动，再次相遇的地方就是重复元素。
     * 解法二：利用set
     */


    public int find1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        // 设定两个指针，一个快指针一个慢指针，指向第一个元素
        int slow = nums[0], fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        // 重置slow到数组开关，一起移动快慢指针，再次相遇即为重复元素。
        slow = nums[0];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int find2(int[] nums) {
        int r = -1;

        if (nums == null || nums.length == 0) {
            return r;
        }

        Set<Integer> sets = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (sets.contains(nums[i])) {
                r = nums[i];
            }
            sets.add(nums[i]);
        }

        return r;
    }



    @Test
    public void test() {
        int[] nums = {1, 3, 4, 2, 2};
        int expected = find1(nums);

        assertEquals(expected, 2);
    }
}
