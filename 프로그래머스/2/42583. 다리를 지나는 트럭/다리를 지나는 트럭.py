from collections import deque

def solution(bridge_length, weight, truck_weights):
    now_weight = 0
    now_length = 0
    answer = 0
    onboardings = deque([0]*bridge_length)
    while truck_weights:
        now_weight -= onboardings.popleft()
        now_length = max(0, now_length-1)
        if now_weight + truck_weights[0] <= weight and now_length+1 <= bridge_length:
            temp = truck_weights.pop(0)
            onboardings.append(temp)
            now_weight += temp
        else:
            onboardings.append(0)
        answer += 1
    
    return answer+bridge_length