def solution(citations):
    answer = 0
    citations.sort(reverse=True)
    n = len(citations)
    
    for i in range(1, n+1):
        if citations[i-1] < i:
            return i-1
    return n