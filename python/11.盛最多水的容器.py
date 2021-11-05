#
# @lc app=leetcode.cn id=11 lang=python3
#
# [11] 盛最多水的容器
#

# @lc code=start
#
# 双指针法
# 左右指针代表的是可以作为容器边界的所有位置的范围（一开始表示数组中所有位置都可以是容器边界）
# 假设左右指针对应的height分别为x和y且x<=y，那么这个时候固定左指针的话无论右指针向内怎么移动得到的容器都不会大于此时，
# 因此，我们已经知晓了左指针在这个位置的时候，其内部所有可能的最大值。从而，我们将左指针向内移动进行下一步遍历。
# 由上所述，每次我们都移动height较小的那个指针，便可以没有遗漏的完成遍历。
class Solution:
    def maxArea(self, height: List[int]) -> int:
        low = 0
        high = len(height) - 1

        max_area = 0
        while low < high:
            max_area = max(max_area, self.__count_area(height, low, high))
            if height[low] < height[high]:
                low += 1
            else:
                high -= 1
        
        return max_area
    
    def __count_area(self, height, x, y):
        return min(height[x], height[y]) * abs(x - y)
# @lc code=end

