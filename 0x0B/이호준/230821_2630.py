import sys
input = sys.stdin.readline

def is_same(row, col, length) -> bool:
    std_col = paper[row][col]
    for i in range(row, row+length):
        for j in range(col, col+length):
            if paper[i][j] != std_col:
                return False
    return True

def recur(row, col, length):
    if length == 1 or is_same(row, col, length):
        answer[paper[row][col]] += 1
        return

    length //= 2

    for i in range(2):
        for j in range(2):
            recur(row+length*i, col+length*j, length)


n = int(input())
paper = [list(map(int, input().split())) for _ in range(n)]
answer = [0, 0]

recur(0, 0, n)

for i in answer:
    print(i)
