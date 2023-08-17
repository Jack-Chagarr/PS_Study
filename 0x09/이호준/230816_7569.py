import sys
from collections import deque
input = sys.stdin.readline

M, N, H = map(int, input().split())
graph = [ [list(map(int, input().split())) for _ in range(N)] for _ in range(H) ]
visited = [ [[False] * M for _ in range(N)] for _ in range(H)]
dist = [ [[0] * M for _ in range(N)] for _ in range(H)]
q = deque()
dy = [0, 1, 0, -1, 0, 0]
dx = [1, 0, -1, 0, 0, 0]
dz = [0, 0, 0, 0, -1, 1]
max_dist = 0
is_impossible = False

for k in range(H):
    for i in range(N):
        for j in range(M):
            if graph[k][i][j] == 1:
                q.append((k, i, j))

while q:
    cz, cy, cx = q.popleft()
    visited[cz][cy][cx] = True
    for i in range(6):
        nz = cz + dz[i]
        ny = cy + dy[i]
        nx = cx + dx[i]
        if (0 <= nz < H and 0 <= ny < N and 0 <= nx < M) and (not graph[nz][ny][nx] and not visited[nz][ny][nx]):
            visited[nz][ny][nx] = True
            dist[nz][ny][nx] = dist[cz][cy][cx] + 1
            q.append((nz, ny, nx))
            max_dist = max(max_dist, dist[nz][ny][nx])

for k in range(H):
    for i in range(N):
        for j in range(M):
            if not (graph[k][i][j] or dist[k][i][j]):
                is_impossible = True
                break
        if is_impossible:
            break
    if is_impossible:
        break

if is_impossible:
    print(-1)
else:
    print(max_dist)
  
