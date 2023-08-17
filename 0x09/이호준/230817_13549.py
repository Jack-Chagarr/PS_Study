import sys
from math import ceil
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())
dist = [-1] * (k+n+1)
q = deque([n])
dist[n] = 0
d_idx = [-1, 1]
answer = 0

while q:
    cur_idx = q.popleft()
    _cur_idx = cur_idx
    if cur_idx == k:
        answer = dist[cur_idx]
        break

    while (2 * _cur_idx < k+n+1) and (_cur_idx != 0):
        if dist[2 * _cur_idx] == -1:
            dist[2 * _cur_idx] = dist[_cur_idx]
            q.append(2 * _cur_idx)
        _cur_idx *= 2

    for i in range(2):
        n_idx = cur_idx + d_idx[i]
        if (0 <= n_idx < k+n+1) and (dist[n_idx] == -1):
            dist[n_idx] = dist[cur_idx] + 1
            q.append(n_idx)

print(answer)
