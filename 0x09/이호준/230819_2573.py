import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
is_splitted = False
is_melt = False
time = 0

while not is_splitted and not is_melt:
    visited = [[False] * m for _ in range(n)]
    q = deque()
    zero_adj_list = []
    ice_cnt = 0
    for row in range(n):
        for col in range(m):
            if graph[row][col] and not visited[row][col]:
                ice_cnt += 1
                if ice_cnt == 2:
                    is_splitted = True
                    break
                q.append((row, col))
                visited[row][col] = True
                while q:
                    cy, cx = q.popleft()
                    ice_adj_cnt = 0
                    for i in range(4):
                        ny = cy + dy[i]
                        nx = cx + dx[i]
                        if (0 <= ny < n and 0 <= nx < m):
                            if graph[ny][nx] == 0:
                                ice_adj_cnt += 1
                            elif not visited[ny][nx]:
                                q.append((ny, nx))
                                visited[ny][nx] = True
                    zero_adj_list.append((cy, cx, ice_adj_cnt))
        if is_splitted:
            break

    if ice_cnt == 0:
        is_melt = True
    
    if is_splitted or is_melt:
        break

    for i in zero_adj_list:
        y, x, ice_adj_cnt = i[0], i[1], i[2]
        graph[y][x] = max(graph[y][x] - ice_adj_cnt, 0)

    time += 1

if is_melt:
    print(0)
else:
    print(time)
  
