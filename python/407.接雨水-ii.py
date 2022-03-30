#
# @lc app=leetcode.cn id=407 lang=python3
#
# [407] 接雨水 II
#

# @lc code=start
class Solution:
    def trapRainWater(self, heightMap) -> int:
        self.matrix = heightMap

        res = 0
        N = self.__find_max()
        for _ in range(N):
            cands = self.__find_candidates()
            if len(cands) < 1:
                continue
            n_holes = self.__find_holes(cands)
            res += n_holes
            self.__minus_one()
    
    def __find_holes(self, cands):
        counts = 0
        max_x = len(self.matrix[0])
        max_y = len(self.matrix)
        tmp = cands.copy()
        # TODO

    def __find_max(self):
        largest = -1
        for row in self.matrix:
            largest = max(largest, max(row))
        return largest
    
    def __find_candidates(self):
        zeros = list()
        max_x = len(self.matrix[0]) - 1
        max_y = len(self.matrix) - 1
        for ri, row in enumerate(self.matrix):
            for zi, zero in enumerate(filter(lambda x: x == 0, row)):
                if ri != 0 and zi != 0 and ri != max_y and zi != max_x:
                    zeros.append((ri, zi))
        return zeros

    def __minus_one(self):
        self.matrix = list(map(lambda x: self.__list_minus(x), self.matrix))
    
    def __list_minus(self, arr, n=1):
        arr[:] = list(map(lambda x: x - n, arr))

# @lc code=end

