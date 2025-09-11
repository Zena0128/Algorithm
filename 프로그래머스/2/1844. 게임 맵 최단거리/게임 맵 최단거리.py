from collections import deque

def check(x, y, n, m):
    return 0 <= x < n and 0 <= y < m

def solution(maps):
    answer = 0
    n = len(maps)
    m = len(maps[0])
    visited = [[0]*m for _ in range(n)]
    queue = deque([(0, 0)])
    visited[0][0] = 1
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
             
    while queue:
        x, y = queue.popleft()
        if x == n-1 and y == m-1:
            return maps[n-1][m-1]
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if check(nx, ny, n, m) and not visited[nx][ny] and maps[nx][ny] > 0:
                queue.append((nx, ny))
                visited[nx][ny] = 1
                maps[nx][ny] += maps[x][y]
    
    return -1