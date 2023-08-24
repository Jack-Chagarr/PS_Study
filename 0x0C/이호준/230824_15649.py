import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [''] * m
is_used= [False] * (n+1)

def backtrack(k):
    if k == m:
        print(' '.join(arr))
        return
    for i in range(1, n+1):
        if not is_used[i]:
            arr[k] = str(i)
            is_used[i] = True
            backtrack(k+1)
            is_used[i] = False

backtrack(0)
