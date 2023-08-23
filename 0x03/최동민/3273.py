n = int(input())
a_list = list(map(int, input().split()))
x = int(input())

cnt = 0

a_list.sort()

left_point = 0
right_point = n - 1

while left_point < right_point:
    if a_list[left_point] + a_list[right_point] < x:
        left_point += 1
    elif a_list[left_point] + a_list[right_point] > x:
        right_point -= 1
    else:
        cnt += 1
        left_point += 1
        right_point -= 1


print(cnt)
