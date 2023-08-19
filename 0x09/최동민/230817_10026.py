import sys
from collections import deque

input = sys.stdin.readline

N = int(input().rstrip())

rgb_dict = {"R": 1, "G": 1, "B": 0}


def bfs(matrix, start, visited, rg):
    queue = deque()
    queue.append(start)
    visited[start[0]][start[1]] = True
    d_list = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    while queue:
        cx, cy = queue.popleft()

        for d in d_list:
            nx = cx + d[0]
            ny = cy + d[1]

            if (
                (0 <= nx < N and 0 <= ny < N)
                and rg == False
                and matrix[nx][ny] == matrix[cx][cy]
                and not visited[nx][ny]
            ):
                queue.append([nx, ny])
                visited[nx][ny] = True

            if (
                (0 <= nx < N and 0 <= ny < N)
                and rg == True
                and rgb_dict[matrix[nx][ny]] == rgb_dict[matrix[cx][cy]]
                and not visited[nx][ny]
            ):
                queue.append([nx, ny])
                visited[nx][ny] = True


matrix = []
visited_rg = [[False for _ in range(N)] for _ in range(N)]
visited_rgb = [[False for _ in range(N)] for _ in range(N)]
rg_cnt = 0
rgb_cnt = 0

for _ in range(N):
    matrix.append(" ".join(input()).split())

for i in range(N):
    for j in range(N):
        if not visited_rg[i][j]:
            bfs(matrix, [i, j], visited_rg, True)
            rg_cnt += 1
        if not visited_rgb[i][j]:
            bfs(matrix, [i, j], visited_rgb, False)
            rgb_cnt += 1

print(rgb_cnt, rg_cnt)
