from collections import deque

def solution(cacheSize, cities):
    answer = 0
    length = 0
    cache = []
    for city in cities:
        lower_city = city.lower()
        try:
            idx = cache.index(lower_city)
        except ValueError:
            idx = -1
        if idx >= 0:
            answer += 1
            cache.pop(idx)
            length -= 1
        else:
            answer += 5
        cache.append(lower_city)
        length += 1
        if length > cacheSize:
            cache.pop(0)
            length -= 1
    return answer