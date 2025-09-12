import heapq

def solution(jobs):
    # (req, dur, idx)
    jobs = [(s, l, i) for i, (s, l) in enumerate(jobs)]
    jobs.sort(key=lambda x: (x[0], x[2]))  # 요청시각, 작업번호

    n = len(jobs)
    pq = []                  # (dur, req, idx)
    t = 0
    i = 0
    done = 0
    total = 0

    while done < n:
        while i < n and jobs[i][0] <= t:
            s, l, idx = jobs[i]
            heapq.heappush(pq, (l, s, idx))
            i += 1

        if pq:
            l, s, idx = heapq.heappop(pq)
            t += l
            total += t - s
            done += 1
        else:
            t = jobs[i][0]

    return total // n
