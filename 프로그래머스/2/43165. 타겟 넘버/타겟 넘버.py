def solution(numbers, target):
    answer = 0
    availables = [0]
    n = len(numbers)
    for i in range(n):
        tmp = []
        for available in availables:
            minus = available+numbers[i]
            plus = available-numbers[i]
            if i == n-1:
                if minus == target:
                    answer += 1
                if plus == target:
                    answer += 1
            tmp.append(minus)
            tmp.append(plus)
        availables = tmp

    return answer