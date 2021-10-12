#
# @lc app=leetcode.cn id=3 lang=python3
#
# [3] 无重复字符的最长子串
#

# @lc code=start


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        index_map = [-1] * 128

        max_len = 0
        start = 0
        for i in range(len(s)):
            start = max(start, index_map[ord(s[i])] + 1)
            new_len = i - start + 1
            max_len = max(max_len, new_len)
            index_map[ord(s[i])] = i

        return max_len

    def old_lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0 or len(s) == 1:
            return len(s)
        
        tmp_list = []
        
        max_len = 0
        for c in s:
            if c not in tmp_list:
                tmp_list.append(c)
                max_len = max(len(tmp_list, max_len))
            else:
                c_index = tmp_list.index(c)
                tmp_list = tmp_list[c_index + 1:]
                tmp_list.append(c)
        
        return max_len
# @lc code=end

