#
# @lc app=leetcode.cn id=476 lang=python3
#
# [476] 数字的补数
#

# @lc code=start
class Solution:
    # 用满额的1减去num. 例，num = 0b101，则用0b111减去num得到其补数0b010
    # runtime beats 33.87 % (36 ms)
    # memory usage beats 22.18 % (15 MB)
    def findComplement(self, num: int) -> int:
        n = 0
        remain = num
        while remain > 0:
            remain = remain >> 1
            n += 1
        
        return 2 ** n - 1 - num
# @lc code=end

