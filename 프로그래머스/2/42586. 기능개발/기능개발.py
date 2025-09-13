import math
from collections import deque

def solution(progresses, speeds):
    times = []
    for progress, speed in zip(progresses, speeds):
        times.append(math.ceil((100-progress)/speed))
    answer = []
    queue = deque([])
    for t in times:
        if not queue:
            queue.append(t)
        else:
            if queue[0] >= t:
                queue.append(t)
            else:
                tmp = 0
                while queue:
                    queue.popleft()
                    tmp += 1
                answer.append(tmp)
                queue.append(t)
    if queue:
        answer.append(len(queue))
    return answer