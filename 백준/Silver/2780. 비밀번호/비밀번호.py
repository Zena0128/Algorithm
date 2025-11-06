tc = int(input())

keypad = [[7], [2, 4], [1, 3, 5], [2, 6], [1, 5, 7], [2, 4, 6, 8], [3, 5, 9], [0, 4, 8], [5, 7, 9], [6, 8]]
dp = [[0]*10 for _ in range(1001)]
# print(dp)
for i in range(10):
    dp[1][i] = 1
for i in range(1, 1000):
    for j in range(10):
        for key in keypad[j]:
            dp[i+1][key] = (dp[i+1][key] + dp[i][j]) % 1234567

for i in range(tc):
    n = int(input())
    print(sum(dp[n])%1234567)
