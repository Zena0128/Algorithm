from collections import deque

def solution(n, edge):
    answer = 0
    vertex = [[] for _ in range(n+1)]
    for a, b in edge:
        vertex[a].append(b)
        vertex[b].append(a)
    visited = [1]*(n+1)
    visited[1] = 1
    queue = deque([1])
        
    while queue:
        now = queue.popleft()
        for node in vertex[now]:
            if visited[node] == 1 and node != 1:
                queue.append(node)
                visited[node] += visited[now]
    max_value = max(visited)
    for v in visited:
        if v == max_value:
            answer += 1
    return answer