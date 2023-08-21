import sys
input = sys.stdin.readline

def recur(a, b, c):
    if b == 1:
        return a % c
    if b % 2 == 0:
        return (recur(a, b//2, c) ** 2) % c
    elif b % 2 == 1:
        return (recur(a, b//2, c) * recur(a, b//2+1, c)) % c

a, b, c = map(int, input().split())
print(recur(a, b, c))
