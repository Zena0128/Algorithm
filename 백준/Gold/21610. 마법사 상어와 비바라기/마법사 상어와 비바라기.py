from collections import deque

global waters, clouds, dx, dy, n

n, m = map(int, input().split())
waters = []
movements = []
clouds = deque([[n-1, 0], [n-1, 1], [n-2, 0], [n-2, 1]])
dx = [0, 0, -1, -1, -1, 0, 1, 1, 1]
dy = [0, -1, -1, 0, 1, 1, 1, 0, -1]

for i in range(n):
    waters.append(list(map(int, input().split())))
    
def move(d, s):
    temp_clouds = []
    while clouds:
        cloud = clouds.popleft()
        x = ((cloud[0]+dx[d]*s)+n)%n
        y = ((cloud[1]+dy[d]*s)+n)%n
        temp_clouds.append([x, y])
        waters[x][y] += 1
    # print(waters)
    # print("temp_clouds ", temp_clouds)
    for temp_cloud in temp_clouds:
        x = temp_cloud[0]
        y = temp_cloud[1]
        for i in range(2, 9, 2):
            nx = x+dx[i]
            ny = y+dy[i]
            
            if (0 <= nx < n) and (0 <= ny < n) and waters[nx][ny] > 0:
                waters[x][y] += 1
    # print(waters)
    cloud_set = set(map(tuple, temp_clouds))
    for i in range(n):
        for j in range(n):
            if waters[i][j] >= 2 and (i, j) not in cloud_set:
                waters[i][j] -= 2
                clouds.append([i, j])

for i in range(m):
    d, s = map(int, input().split())
    move(d, s)
    # print(waters)

ans = 0
for i in range(n):
    for j in range(n):
        ans += waters[i][j]
print(ans)

