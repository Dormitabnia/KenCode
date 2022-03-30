class Solution:
    def solve(self, n, m, bomb):
        self.n_rooms = n
        self.mem = dict()
        return self.get_min_ene(1, bomb, 0)
    
    def get_min_ene(self, cur_room, bomb, cur_time):
        if len(bomb) == 0:
            return 0
        if len(bomb) == 1:
            return 1 if bomb[0] == cur_room else 0
        if (cur_room, cur_time) in self.mem:
            print('get from buffer')
            return self.mem[(cur_room, cur_time)]
        
        if bomb[0] != cur_room:
            res = self.get_min_ene(cur_room, bomb[1:], cur_time + 1)
            self.mem[(cur_room, cur_time)] = res
            return res
        
        next_rooms_res = list()
        for i in range(self.n_rooms):
            new_room_id = i + 1
            if new_room_id == cur_room:
                continue
            next_rooms_res.append(self.get_min_ene(new_room_id, bomb[1:], cur_time + 1))
        
        res = 1 + min(next_rooms_res)
        self.mem[(cur_room, cur_time)] = res
        return res


if __name__ == "__main__":
    n, m = input().split(' ')
    n, m = int(n), int(m)
    bomb = input().split(' ')
    bomb = [int(x) for x in bomb]
    
    s = Solution()
    res = s.solve(n, m, bomb)
    print(s.mem)
    print(res)
