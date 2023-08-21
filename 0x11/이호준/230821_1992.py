import sys
input = sys.stdin.readline

def is_same(row, col, length):
    std_col = pic[row][col]
    for i in range(row, row+length):
        for j in range(col, col+length):
            if pic[i][j] != std_col:
                return False
    return True

def recur(row, col, length):
    global answer

    if length == 1 or is_same(row, col, length):
        answer.append(str(pic[row][col]))
        return

    answer.append('(')
    length //= 2
    for i in range(2):
        for j in range(2):
            recur(row+length*i, col+length*j, length)
    answer.append(')')


n = int(input())
pic = [ list(map(int, list(input().rstrip()))) for _ in range(n)]
answer = []
recur(0, 0, n)
print(''.join(answer))
