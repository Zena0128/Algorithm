def solution(m, n, puddles):
    dp = [[1]*m for _ in range(n)]
    for x, y in puddles:
        dp[y-1][x-1] = 0
    answer = 0
    
    for i in range(n):
        for j in range(m):
            if i == 0 and j == 0:
                continue
            if dp[i][j] > 0:
                tmp = 0
                if i-1 >= 0:
                    tmp += dp[i-1][j]
                if j-1 >= 0:
                    tmp += dp[i][j-1]
                dp[i][j] = tmp
    
    return dp[n-1][m-1] % 1000000007