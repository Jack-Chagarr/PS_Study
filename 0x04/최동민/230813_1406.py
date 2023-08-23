import sys

input = sys.stdin.readline

left_stack = " ".join(input().rstrip()).split()
M = int(input())
right_stack = []
for i in range(M):
    temp_str = input().rstrip()

    if temp_str == "L":
        if left_stack:
            right_stack.append(left_stack.pop())
    elif temp_str == "D":
        if right_stack:
            left_stack.append(right_stack.pop())

    elif temp_str == "B":
        if left_stack:
            left_stack.pop()

    else:
        left_stack.append(temp_str.split()[-1])

print("".join(left_stack) + "".join(reversed(right_stack)))
