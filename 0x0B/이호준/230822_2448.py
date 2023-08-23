import sys
input = sys.stdin.readline

n = int(input())
answer = [[' '] * (2*n-1) for _ in range(n)]

def recur(n, row, col):
    if n == 3:
        for i in range(n):
            for j in range(i+1):
                if i == 1 and j == 0:
                    continue
                answer[row+i][col-j] = '*'
                answer[row+i][col+j] = '*'

    else:
        n //= 2
        for i in range(2):
            recur(n, row+n*i, col+n*i)
            recur(n, row+n*i, col-n*i)

recur(n, 0, (2*n-1)//2)

for i in answer:
    print(''.join(i))
