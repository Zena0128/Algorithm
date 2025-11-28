d, k = map(int, input().split())

a_list = [0] * 31
b_list = [0] * 31

a_list[1], a_list[3], a_list[4] = 1, 1, 1
b_list[2], b_list[3], b_list[4] = 1, 1, 2

for i in range(5, 31):
    a_list[i] = a_list[i-1] + a_list[i-2]
    b_list[i] = b_list[i-1] + b_list[i-2]

idx = 1

a_cnt = a_list[d]
b_cnt = b_list[d]

for i in range(1, k):
    if (k-a_cnt*i)%b_cnt == 0:
        print(i)
        print((k-a_cnt*i)//b_cnt)
        break