import sys
from collections import deque

input = sys.stdin.readline

T = int(input().rstrip())


def bfs(matrix, start, visited):
    queue = deque()
    queue.append(start)
    visited[start[0]][start[1]] = True
    d_list = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    while queue:
        cur = queue.popleft()

        for d in d_list:
            temp_x = cur[0] + d[0]
            temp_y = cur[1] + d[1]

            if matrix[temp_x][temp_y] == 1 and not visited[temp_x][temp_y]:
                queue.append([temp_x, temp_y])
                visited[temp_x][temp_y] = True


for _ in range(T):
    M, N, K = map(int, input().split())
    matrix = [[0 for _ in range(M + 2)] for _ in range(N + 2)]
    visited = [[False for _ in range(M + 2)] for _ in range(N + 2)]
    cnt = 0

    candidate_list = []

    for _ in range(K):
        x, y = map(int, input().split())
        matrix[y + 1][x + 1] = 1

        candidate_list.append([y + 1, x + 1])

    for candidate_start in candidate_list:
        if not visited[candidate_start[0]][candidate_start[1]]:
            bfs(matrix, candidate_start, visited)
            cnt += 1

    print(cnt)
