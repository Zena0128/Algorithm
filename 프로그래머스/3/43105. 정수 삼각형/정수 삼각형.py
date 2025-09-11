def solution(triangle):
    n = len(triangle)
    tmp = []
    for i in range(1, n):
        triangle[i][0] += triangle[i-1][0]
        triangle[i][i] += triangle[i-1][i-1]
    if n > 2:
        for i in range(2, n):
            for j in range(1, i):
                triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])
    return max(triangle[n-1])