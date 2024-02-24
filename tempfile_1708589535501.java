import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            
            // 如果前一个元素存在，尝试向左扩展序列
            if (numMap.containsKey(num - 1)) {
                int leftNum = num - 1;
                while (numMap.containsKey(leftNum)) {
                    count += numMap.get(leftNum);
                    leftNum--;
                }
            }
            
            // 如果后一个元素存在，尝试向右扩展序列
            if (numMap.containsKey(num + 1)) {
                int rightNum = num + 1;
                while (numMap.containsKey(rightNum)) {
                    count += numMap.get(rightNum);
                    rightNum++;
                }
            }

            maxLen = Math.max(maxLen, count);
        }

        return maxLen;
    }
}
