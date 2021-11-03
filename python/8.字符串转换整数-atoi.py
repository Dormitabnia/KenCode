#
# @lc app=leetcode.cn id=8 lang=python3
#
# [8] 字符串转换整数 (atoi)
#

# @lc code=start
class Solution:
    # runtime beats 84.99 % (32 ms)
    # memory usage beats 35.82 % (15 MB)
    def myAtoi(self, s: str) -> int:
        s = s.lstrip()

        sign = 1
        sign_read = False
        int_str = ''
        for char in s:
            if not sign_read and (char == '+' or char == '-'):
                sign = -1 if char == '-' else 1
                sign_read = True
            elif ord(char) <= ord('9') and ord(char) >= ord('0'):
                int_str += char
                sign_read = True
            else:
                break
        
        if int_str == '':
            return 0
        
        res = min(max(int(int_str) * sign, -2 ** 31), 2 ** 31 - 1)
        return res
# @lc code=end

