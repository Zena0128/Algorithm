def solution(n, lost, reserve):
    lost = set(lost)
    reserve = set(reserve)
    both = lost.intersection(reserve)
    lost -= both
    reserve -= both
    answer = 0
    lost = list(lost)
    reserve = list(reserve)
    
    for r in reserve:
        if r-1 in lost:
            lost.remove(r-1)
            continue
        if r+1 in lost:
            lost.remove(r+1)
    
    return n-len(lost)