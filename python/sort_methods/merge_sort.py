"""
归并排序
2021/10/14
"""
def msorted(arr):
    arr[:] = do_msort(arr)


def do_msort(arr):
    if len(arr) == 1:
        return arr
    mid = len(arr) // 2
    return merge(do_msort(arr[:mid]), do_msort(arr[mid:]))


# 有序合并两个有序列表
def merge(arr1, arr2):
    res = list()
    i, j = 0, 0
    while i < len(arr1) and j < len(arr2):
        if arr1[i] < arr2[j]:
            res.append(arr1[i])
            i += 1
        else:
            res.append(arr2[j])
            j += 1

    if i < len(arr1):
        res.extend(arr1[i:])
    if j < len(arr2):
        res.extend(arr2[j:])
    return res


if __name__ == "__main__":
    sample = [2, 7, 16, 3, 6, 4, 1]
    msorted(sample)
    print(sample)
