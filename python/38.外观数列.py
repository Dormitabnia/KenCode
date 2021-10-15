#
# @lc app=leetcode.cn id=38 lang=python3
#
# [38] 外观数列
#

# @lc code=start
class Solution:
    # runtime beats 7.29 % (64 ms)
    # memory usage beats 29.56 % (15.1 MB)
    def countAndSay(self, n: int) -> str:
        num_str = '1'
        for _ in range(n - 1):
            num_str = self.describe_num(num_str)
        
        return num_str
    
    def describe_num(self, s) -> str:
        if len(s) < 1:
            return ''
        res = ''
        
        i = 0
        n = 0
        char = s[0]

        while i < len(s):
            while i < len(s) and s[i] == char:
                n += 1
                i += 1
            res += '{}{}'.format(n, char)
            if i == len(s): break
            char = s[i]
            n = 0
            
        return res
# @lc code=end

