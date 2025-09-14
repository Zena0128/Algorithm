def solution(sticker):
    answer = 0
    n = len(sticker)
    dp1 = [0] * n
    dp2 = [0] * n
    if n <= 3:
        return max(sticker)
    dp1[0] = sticker[0]
    dp1[1] = sticker[0]
    dp2[1] = sticker[1]
    for i in range(2, n):
        if i == n-1:
            dp1[i] = dp1[i-1]
        else:
            dp1[i] = max(dp1[i-1], dp1[i-2]+sticker[i])
        dp2[i] = max(dp2[i-1], dp2[i-2]+sticker[i])
    return max(dp1[-1], dp2[-1])