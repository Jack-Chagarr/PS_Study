import sys
input = sys.stdin.readline

n = int(input())
answer = [[' '] * n for _ in range(n)]

def recur(n, row, col):
    if n == 3:
        for i in range(3):
            for j in range(3):
                if i == 1 and j == 1:
                    continue
                answer[row+i][col+j] = '*'
    else:
        n //= 3
        for i in range(3):
            for j in range(3):
                if i == 1 and j == 1:
                    continue
                recur(n, row+n*i, col+n*j)

recur(n, 0, 0)
for i in answer:
    print(''.join(i))
