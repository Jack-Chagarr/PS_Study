import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [list(map(int, input().rstrip())) for _ in range(n)]
visited = [[[0] * 2 for _ in range(m)] for _ in range(n)]
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]

visited[0][0][0] = 1
q = deque([(0, 0, 0)])

def bfs():
    while q:
        cy, cx, dest = q.popleft()
        if cy == n-1 and cx == m-1:
            return visited[cy][cx][dest]
        for i in range(4):
            ny = cy + dy[i]
            nx = cx + dx[i]
            if (0 <= ny < n and 0 <= nx < m) and not visited[ny][nx][dest]:
                if graph[ny][nx] == 0:
                    visited[ny][nx][dest] = visited[cy][cx][dest] + 1
                    q.append((ny, nx, dest))
                elif graph[ny][nx] == 1:
                    if dest == 1:
                        continue
                    elif dest == 0:
                        q.append((ny, nx, 1))
                        visited[ny][nx][1] = visited[cy][cx][dest] + 1

answer = bfs()
if answer:
    print(answer)
else:
    print(-1)
