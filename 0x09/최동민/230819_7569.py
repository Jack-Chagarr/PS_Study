import sys
from collections import deque

input = sys.stdin.readline

M, N, H = map(int, input().split())

matrix = []
dist = [[[0 for _ in range(M)] for _ in range(N)] for _ in range(H)]
start_queue = []


for _ in range(H):
    temp_matrix = []
    for _ in range(N):
        temp_matrix.append(list(map(int, input().split())))
    matrix.append(temp_matrix)

for k in range(M):
    for j in range(N):
        for i in range(H):
            if matrix[i][j][k] == 1:
                start_queue.append([i, j, k])
            elif matrix[i][j][k] == 0:
                dist[i][j][k] = -1


def bfs(start_queue, dist):
    queue = deque(start_queue)

    d_list = [
        [0, 1, 0],
        [1, 0, 0],
        [0, -1, 0],
        [-1, 0, 0],
        [0, 0, 1],
        [0, 0, -1],
    ]
    while queue:
        cx, cy, cz = queue.popleft()

        for d in d_list:
            nx = cx + d[0]
            ny = cy + d[1]
            nz = cz + d[2]

            if (0 <= nx < H and 0 <= ny < N and 0 <= nz < M) and dist[nx][ny][nz] < 0:
                queue.append([nx, ny, nz])
                dist[nx][ny][nz] = dist[cx][cy][cz] + 1


bfs(start_queue, dist)


def test():
    cnt = 0
    for k in range(M):
        for j in range(N):
            for i in range(H):
                cnt = max(cnt, dist[i][j][k])
                if dist[i][j][k] == -1:
                    cnt = -1
                    print(cnt)
                    return cnt

    print(cnt)


test()
