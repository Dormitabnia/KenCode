"""
堆排序

"""
class HeapSort:
    def sortArray(self, nums):
        for i in range(len(nums) - 1, -1, -1):
            self.max_heapify(nums, i, len(nums) - 1)
        
        nums[-1], nums[0] = nums[0], nums[-1]
        it = len(nums) - 2
        while it > 0:
            self.max_heapify(nums, 0, it)
            nums[it], nums[0] = nums[0], nums[it]
            it -= 1
        
        return nums
        
    def max_heapify(self, arr, start, end):
        p = start
        # 当前结点的左右结点为p * 2 + 1和p * 2 + 2
        while p * 2 + 1 <= end:
            left_child, right_child = p * 2 + 1, p * 2 + 2
            if right_child > end or arr[left_child] > arr[right_child]:
                next_node = left_child
            else:
                next_node = right_child
            
            # 如果比子节点小，则将最大的子节点与父节点交换，并对交换后的子树进行进一步heapify
            if arr[p] < arr[next_node]:
                arr[p], arr[next_node] = arr[next_node], arr[p]
                p = next_node
            # heapify已完成
            else:
                break
