import sys
input = sys.stdin.readline

def is_same(row, col, length) -> bool:
    first_num = paper[row][col]
    for i in range(row, row+length):
        for j in range(col, col+length):
            if paper[i][j] != first_num:
                return False
    return True

def recur(row, col, length):
    if length == 1 or is_same(row, col, length):
        num_cnt_dict[paper[row][col]] += 1
        return

    length //= 3
    for i in range(3):
        for j in range(3):
            recur(row+length*i, col+length*j, length)

n = int(input())
paper = [list(map(int, input().split())) for _ in range(n)]
num_cnt_dict = {-1: 0, 0: 0, 1: 0}
recur(0, 0, n)
answers = num_cnt_dict.values()
for answer in answers:
    print(answer)
