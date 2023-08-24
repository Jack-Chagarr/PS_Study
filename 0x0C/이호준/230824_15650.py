import sys
input = sys.stdin.readline

def backtrack(k):
    if k == m+1:
        print(' '.join(answer[1:]))
        return
    
    for i in range(1, n+1):
        if not is_used[i] and i > int(answer[k-1]):
            answer[k] = str(i)
            is_used[i] = True
            backtrack(k+1)
            is_used[i] = False


n, m = map(int, input().split())
is_used = [True] + ([False] * (n+1))
answer = ['0'] + ([''] * m)

backtrack(1)
