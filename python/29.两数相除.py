#
# @lc app=leetcode.cn id=29 lang=python3
#
# [29] 两数相除
#

# @lc code=start
class Solution:
    # runtime beats 81.85 % (32 ms)
    # memory usage beats 97.46 % (14.8 MB)
    def divide(self, dividend: int, divisor: int) -> int:
        if divisor == 1:
            res = dividend
        elif divisor == -1:
            res = -dividend
        elif dividend == 0 or abs(dividend) < abs(divisor):
            res = 0
        else:
            dividend_sign = 1 if dividend >= 0 else -1
            divisor_sign = 1 if divisor >= 0 else -1

            remains = abs(dividend)
            divisor = abs(divisor)

            res = 0
            while remains > max(10, divisor):
                n = 0
                tmp = remains
                while True:
                    tmp = tmp >> 1
                    if tmp < divisor:
                        break
                    n += 1
                
                if n == 0: 
                    break
                else:
                    res += 2 ** n
                    remains -= 2 ** n * divisor

            while remains >= divisor:
                res += 1
                remains -= divisor
            
            if dividend_sign != divisor_sign:
                res = -res
        
        if res > 2 ** 31 - 1 or res < -2 ** 31:
            res = 2 ** 31 - 1
        
        return res
# @lc code=end

