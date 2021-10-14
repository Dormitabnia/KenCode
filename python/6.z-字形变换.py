#
# @lc app=leetcode.cn id=6 lang=python3
#
# [6] Z 字形变换
#

# @lc code=start
class Solution:
    # 完全的找规律解法
    # runtime beats 48.9 % (56 ms)
    # memory usage beats 87.15 % (15 MB)
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1 or len(s) <= 1:
            return s

        res_str = ''

        for row in range(numRows):
            p = row
            odd_flag = 0
            while p < len(s):
                res_str += s[p]
                if row == 0 or row == numRows - 1:
                    p += 2 * (numRows - 1)
                else:
                    if odd_flag == 0:
                        p = 0
                        p += 2 * (numRows - 1) - row
                        odd_flag = 1
                    elif odd_flag == 1:
                        p += 2 * row
                        odd_flag = 2
                    elif odd_flag == 2:
                        p += 2 * (numRows - 1) - 2 * row
                        odd_flag = 1
        
        return res_str
# @lc code=end

