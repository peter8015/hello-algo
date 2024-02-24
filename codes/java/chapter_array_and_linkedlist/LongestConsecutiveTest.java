package chapter_array_and_linkedlist;

/**
 * @author zhanghaibing
 * @date 2024-02-22
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LongestConsecutiveTest {
    private LongestConsecutive solution = new LongestConsecutive();

    @Test
    public void testLongestConsecutive() {
        // 测试用例1：包含重复元素，最长连续序列是[0, 1, 2, 3, 4, 5, 6, 7, 8]
        int[] nums1 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        assertEquals(9, solution.longestConsecutive(nums1));

        // 测试用例2：没有重复元素，最长连续序列是[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 9};
        assertEquals(8, solution.longestConsecutive(nums2));

        // 测试用例3：空数组
        int[] nums3 = {};
        assertEquals(0, solution.longestConsecutive(nums3));

        // 测试用例4：单个元素
        int[] nums4 = {0};
        assertEquals(1, solution.longestConsecutive(nums4));

        // 测试用例5：负数和正数混合，最长连续序列是[-5, -4, -3, -2, -1, 0, 1, 2, 3, 4]
        int[] nums5 = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        assertEquals(11, solution.longestConsecutive(nums5));

        // 测试用例6：包含重复元素，最长连续序列是[1, 2, 0, 1]
        int[] nums6 = {1, 0, 1, 2};
        assertEquals(3, solution.longestConsecutive(nums6));
    }
}



