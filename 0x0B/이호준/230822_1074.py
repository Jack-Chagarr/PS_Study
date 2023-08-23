import sys
input = sys.stdin.readline

def recur(length, row, col):
    global answer, r, c, done

    if length == 2:
        for i in range(2):
            for j in range(2):
                answer += 1
                if row+i == r and col+j == c:
                    done = True
                    return done
        return 

    length //= 2
    for i in range(2):
        for j in range(2):
            if (row + length*i <= r < row + length*(i+1)) and (col + length*j <= c < col + length * (j+1)): 
                if recur(length, row+length*i, col+length*j):
                    return done
            else:
                answer += length ** 2

n, r, c = map(int, input().split())
length = 2 ** n
answer = -1
done = False
recur(length, 0, 0)
print(answer)
