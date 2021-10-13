#
# @lc app=leetcode.cn id=5 lang=python3
#
# [5] 最长回文子串
#

# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> str:
        longest_str = ''

        for i in range(len(s)):
            # 以当前字母为中心，向两边扩展
            left, right = i, i
            # 找到中间的可重复部分
            while right < len(s) - 1 and s[right + 1] == s[left]:
                right += 1
            # 找到两侧的对称部分
            while right < len(s) - 1 and left > 0 and s[right + 1] == s[left - 1]:
                right += 1
                left -= 1
            if len(s[left: right + 1]) > len(longest_str):
                longest_str = s[left: right + 1]
            
        return longest_str


    def high_cost_longestPalindrome(self, s: str) -> str:
        if self.__is_palindrome(s):
            return s
        
        longest_substr = ''

        for start in range(len(s)):
            for end in range(start + 1, len(s) + 1):
                if self.__is_palindrome(s[start: end]) and len(s[start: end]) > len(longest_substr):
                    longest_substr = s[start: end]
        
        return longest_substr
        
    def __is_palindrome(self, s):
        if len(s) == 1 or len(s) == 0:
            return True
        p1, p2 = 0, len(s) - 1
        while True:
            if s[p1] != s[p2]:
                return False
            p1 += 1
            p2 -= 1
            if p1 >= p2:
                return True
# @lc code=end

