def available(lost, r):
    try:
        idx = lost.index(r)
    except ValueError:
        idx = -1
    return idx

def solution(n, lost, reserve):
    lost = set(lost)
    reserve = set(reserve)
    both = lost.intersection(reserve)
    lost = lost - both
    reserve = reserve - both
    answer = n-len(lost)

    for r in reserve:
        if len(lost) == 0:
            return answer
        for i in [-1, 1]:
            if r+i in lost:
                lost.remove(r+i)
                answer += 1
                break
    return answer