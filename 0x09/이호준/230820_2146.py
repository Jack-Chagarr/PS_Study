import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
island_visited = [[False] * n for _ in range(n)]
island_q = deque()
island_num = 0
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
shortest_len = sys.maxsize

for row in range(n):
    for col in range(n):
        if graph[row][col] and not island_visited[row][col]:
            island_num += 1
            island_q.append((row, col))
            island_visited[row][col] = True
            graph[row][col] = island_num
            while island_q:
                cy, cx = island_q.popleft()
                for i in range(4):
                    ny = cy + dy[i]
                    nx = cx + dx[i]
                    if (0 <= ny < n) and (0 <= nx < n) and (graph[ny][nx] and not island_visited[ny][nx]):
                        island_q.append((ny, nx))
                        island_visited[ny][nx] = True
                        graph[ny][nx] = island_num

def bfs(num):
    global dy, dx, shortest_len

    dist = [[0] * n for _ in range(n)]
    visited = [[False] * n for _ in range(n)]
    q = deque()

    for row in range(n):
        for col in range(n):
            if graph[row][col] == num:
                q.append((row, col))
                visited[row][col] = True
    while q:
        cy, cx = q.popleft()
        for i in range(4):
            ny = cy + dy[i]
            nx = cx + dx[i]
            if (0 <= ny < n and 0 <= nx < n) and not visited[ny][nx]:
                if graph[ny][nx] == 0:
                    dist[ny][nx] = dist[cy][cx] + 1
                    q.append((ny, nx))
                    visited[ny][nx] = True
                elif graph[ny][nx] != num:
                    shortest_len = min(shortest_len, dist[cy][cx])

for num in range(1, island_num+1):
    bfs(num)
    
print(shortest_len)
