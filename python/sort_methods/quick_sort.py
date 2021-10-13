"""
快速排序
2021/10/12
"""
def qsorted(arr):
    __do_qsort(arr, 0, len(arr) - 1)


def __do_qsort(arr, start, end):
    if end - start < 1:
        return
    
    flag = arr[start]
    h = end
    l = start
    while l < h:
        while arr[h] >= flag and l < h:
            h -= 1
        arr[l] = arr[h]
        while arr[l] <= flag and l < h:
            l += 1
        arr[h] = arr[l]
    
    arr[l] = flag
    __do_qsort(arr, start, l - 1)
    __do_qsort(arr, l + 1, end)


if __name__ == "__main__":
    tlist = [7, 2, 15, 11]
    qsorted(tlist)
    print(tlist)
