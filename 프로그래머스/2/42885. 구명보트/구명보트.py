def check(a, b, limit):
    return (a+b) <= limit

def solution(people, limit):
    answer = 0
    people.sort(reverse=True)
    n = len(people)
    
    i = 0
    j = n-1
    while i <= j:
        if check(people[i], people[j], limit):
            j -= 1
        i += 1
        answer += 1
    
    return answer