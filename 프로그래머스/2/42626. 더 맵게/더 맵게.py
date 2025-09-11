import heapq

def mix(a, b):
    return a + 2*b

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    if scoville[0] >= K:
        return answer
    
    while len(scoville) > 1:
        heapq.heappush(scoville, mix(heapq.heappop(scoville), heapq.heappop(scoville)))
        answer += 1
        if scoville[0] >= K:
            return answer
    
    return -1