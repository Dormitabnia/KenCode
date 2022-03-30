#
# @lc app=leetcode.cn id=211 lang=python3
#
# [211] 添加与搜索单词 - 数据结构设计
#

# @lc code=start
class WordDictionary:

    def __init__(self):
        self.dic = list()
        self.starts = [-1] * 26
        self.ends = [-1] * 26

    def addWord(self, word: str) -> None:
        if self.search(word):
            return
        
        new_indx = -1
        change_s = False
        change_e = False
        change_as = -1
        change_ae = -1
        a_indx = ord(word[0]) - ord('a')

        if len(self.dic) == 0 or word < self.dic[0]:
            new_indx = 0
            change_as, change_ae = a_indx, a_indx
            change_s = True
            change_e = self.ends[a_indx] == -1
        elif word > self.dic[len(self.dic) - 1]:
            new_indx = len(self.dic) - 1
            change_e = True
            change_s = self.starts[a_indx] == -1
        else:
            search_starts = self.starts[a_indx]
            search_ends = self.ends[a_indx]

            if search_starts == -1:
                l = max(a_indx - 1, 0)
                while l >= 0 and self.starts[l] == -1:
                    l -= 1
                if l >= 0:
                    new_indx = self.ends[l] + 1
                else:
                    h = min(a_indx + 1, 25)
                    while h < 26 and self.starts[h] == -1:
                        h += 1
                    if h < 26:
                        new_indx = self.starts[h]
                change_as, change_ae = a_indx + 1, a_indx + 1
                change_s, change_e = True, True
            else:
                if word < self.dic[search_starts]:
                    new_indx = search_starts
                    change_s = True
                elif word > self.dic[search_ends]:
                    new_indx = search_ends + 1
                    change_e = True
                else:
                    for i in range(search_starts, search_ends + 1):
                        if word > self.dic[i] and word < self.dic[i + 1]:
                            new_indx = i + 1
                            break
                change_as, change_ae = a_indx + 1, a_indx
        
        self.dic.insert(new_indx, word)

        if change_as >= 0:
            for i in range(change_as, 26):
                if self.starts[i] != -1:
                    self.starts[i] += 1
        if change_ae >= 0:
            for i in range(change_ae, 26):
                if self.ends[i] != -1:
                    self.ends[i] += 1
        if change_s:
            self.starts[a_indx] = new_indx
        if change_e:
            self.ends[a_indx] = new_indx

    def search(self, word: str) -> bool:
        if word[0] == '.':
            return word in self.dic
        else:
            a_indx = ord(word[0]) - ord('a')
            return word in self.dic[self.starts[a_indx]:self.ends[a_indx] + 1]


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
# @lc code=end

