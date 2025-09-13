from collections import deque

def check(queue, stack):
    # print(queue)
    for x in queue:
        # print(list(stack), " : stack")
        if x in ["(", "[", "{"]:
            stack.append(x)
        else:
            if not stack:
                return 0
            else:
                if x == ")":
                    y = "("
                else:
                    if x == "]":
                        y = "["
                    else:
                        y = "{"
                if stack[-1] != y:
                    return 0
                else:
                    stack.pop()
    if stack:
        return 0
    return 1

def solution(s):
    answer = 0
    n = len(s)
    queue = deque(s)
    for i in range(n): # 왼쪽으로 i칸만큼 회전시키기
        queue.append(queue.popleft())
        stack = []
        answer += check(queue, stack) # 올바른 괄호 문자열인지 체크하기
        # print("answer: ", answer)
                    
    return answer