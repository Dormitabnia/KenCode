if __name__ == "__main__":
    n_len = int(input())
    if n_len == 0:
        print(0)
    num_list = input()
    num_list = [int(x) for x in num_list.split(' ')]
    
    n_seq = 0
    dp = [0 for _ in range(n_len)]
    for i in range(n_len):
        if i > 0 and num_list[i - 1] == 1:
            dp[i] = dp[i - 1] - 1
            n_seq += dp[i]
            continue
        if i > 0 and num_list[i - 1] == -1:
            dp[i] = (n_len - (i - 1)) - dp[i - 1] - 1
            n_seq += dp[i]
            continue
        n_minus_1 = 0
        for j in range(i, n_len):
            if num_list[j] == -1:
                n_minus_1 += 1
            if n_minus_1 % 2 == 0:
                dp[i] += 1
        n_seq += dp[i]
    
    print(n_seq)
