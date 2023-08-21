import sys
input = sys.stdin.readline

def hanoi(n, start, mid, end):
    global cnt
    cnt += 1

    if n == 1:
        history.append((start, end))
        return
    else:
        hanoi(n-1, start, end, mid)
        history.append((start, end))
        hanoi(n-1, mid, start, end)

n = int(input())
cnt = 0
history = []
hanoi(n, '1', '2', '3')
print(cnt)
for i in history:
    print(' '.join(i))
