import sys

input = sys.stdin.readline

M = int(input())

stack = []

for i in range(M):
    temp_str = input().split()

    if temp_str[0] == "push":
        stack.append(temp_str[1])

    elif temp_str[0] == "pop":
        if stack:
            print(stack.pop())
        else:
            print(-1)

    elif temp_str[0] == "size":
        print(len(stack))

    elif temp_str[0] == "empty":
        if stack:
            print(0)
        else:
            print(1)

    elif temp_str[0] == "top":
        if stack:
            print(stack[-1])
        else:
            print(-1)
