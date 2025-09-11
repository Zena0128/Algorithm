import sys

def solution(clothes):
    answer = 1
    clothes_dict = dict()
    for cloth in clothes: # dictionary에 각 카테고리에 속하는 의상을 저장
        if cloth[1] not in clothes_dict.keys():
            clothes_dict[cloth[1]] = [cloth[0]]
        else:
            clothes_dict[cloth[1]].append(cloth[0])
    
    for cat in clothes_dict.keys():
        answer *= len(clothes_dict[cat])+1 # 입을 수 있는 의상 조합 수 == 각 카테고리 내에서 고를 수 있는 의상 조합 수끼리 곱한 값 - 1
        
        
    return answer-1