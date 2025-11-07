import sys
input = sys.stdin.readline

n, q = map(int, input().split())
available = [True for _ in range(n+1)]

for i in range(q):
    x = int(input())
    ans = 0
    tmp = x
    while tmp > 1:
        if not available[tmp]:
            ans = tmp
        tmp = tmp // 2
    available[x] = False
    print(ans)