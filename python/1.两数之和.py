#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        notebook = {}
        for i, num in enumerate(nums):
            pair = target - num
            if pair in notebook:
                return [i, notebook[pair]]
            notebook[num] = i
        return None
        
        # for i in range(len(nums)):
        #     for j in range(i + 1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return [i, j]
# @lc code=end

