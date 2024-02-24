def longestConsecutive(nums):
    if not nums:
        return 0
    
    nums.sort()
    max_len = 1
    left, right = 0, 0
    
    while right < len(nums) - 1:
        if nums[right] == nums[right + 1] - 1:
            right += 1
            current_len = right - left + 1
        else:
            if current_len > max_len:
                max_len = current_len
            left = right = right + 1
            current_len = 1
        
    # 处理最后一个可能的连续序列
    if current_len > max_len:
        max_len = current_len
        
    return max_len
