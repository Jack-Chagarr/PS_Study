import sys
from collections import deque

input = sys.stdin.readline

T = int(input().rstrip())

for _ in range(T):
    M, N = map(int, input().split())

    matrix = []
    dist_fire = [[(-1) for _ in range(M)] for _ in range(N)]
    dist_dog = [[(-1) for _ in range(M)] for _ in range(N)]

    for _ in range(N):
        matrix.append(" ".join(input().split()))

    queue_dog = deque()
    queue_fire = deque()

    for i in range(N):
        for j in range(M):
            if matrix[i][j] == "@":
                queue_dog.append([i, j])
                dist_dog[i][j] = 0

            elif matrix[i][j] == "*":
                queue_fire.append([i, j])
                dist_fire[i][j] = 0

    d_list = [[0, 1], [1, 0], [0, -1], [-1, 0]]

    while queue_fire:
        cx, cy = queue_fire.popleft()

        for d in d_list:
            nx = cx + d[0]
            ny = cy + d[1]

            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if dist_fire[nx][ny] >= 0 or matrix[nx][ny] == "#":
                continue

            dist_fire[nx][ny] = dist_fire[cx][cy] + 1
            queue_fire.append([nx, ny])

    escape = False

    while queue_dog:
        cx, cy = queue_dog.popleft()

        for d in d_list:
            nx = cx + d[0]
            ny = cy + d[1]
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                escape = True
                break
            if dist_dog[nx][ny] >= 0 or matrix[nx][ny] == "#":
                continue
            if (dist_fire[nx][ny] <= dist_dog[cx][cy] + 1) and dist_fire[nx][ny] >= 0:
                continue
            dist_dog[nx][ny] = dist_dog[cx][cy] + 1
            queue_dog.append([nx, ny])
        if escape:
            break

    if not escape:
        print("IMPOSSIBLE")
    else:
        print(dist_dog[cx][cy] + 1)
