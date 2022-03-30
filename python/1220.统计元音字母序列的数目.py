#
# @lc app=leetcode.cn id=1220 lang=python3
#
# [1220] 统计元音字母序列的数目
#
# 使用动态规划，将aeiou定义为以该字母结尾的序列的数量
# 以a结尾的n长度序列来自于以eiu结尾的n-1长度序列+a

# @lc code=start
class Solution:
    def countVowelPermutation(self, n: int) -> int:
        MOD = 10 ** 9 + 7
        a, e, i, o, u = 1, 1, 1, 1, 1

        for _ in range(n - 1):
            a, e, i, o, u = (e + i + u) % MOD, (a + i) % MOD, (e + o) % MOD, i, (i + o) % MOD
        
        return (a + e + i + o + u) % MOD
# @lc code=end
