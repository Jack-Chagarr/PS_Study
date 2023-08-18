import sys
from collections import deque
input = sys.stdin.readline

tc = int(input())
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]

for _ in range(tc):
    w, h = map(int, input().split())
    graph = [input() for _ in range(h)]
    answer = 0

    dist_fire = [[sys.maxsize] * w for _ in range(h)]
    visited_fire = [[False] * w for _ in range(h)]
    q_fire = deque()

    dist_sg = [[sys.maxsize] * w for _ in range(h)]
    visited_sg = [[False] * w for _ in range(h)]
    q_sg = deque()

    for row in range(h):
        for col in range(w):
            if graph[row][col] == '*':
                q_fire.append((row, col))
                dist_fire[row][col] = 0
                visited_fire[row][col] = True
            if graph[row][col] == '@':
                q_sg.append((row, col))
                dist_sg[row][col] = 0
                visited_sg[row][col] = True
    
    while q_fire:
        cy,cx = q_fire.popleft()
        for i in range(4):
            ny = cy + dy[i]
            nx = cx + dx[i]
            if (0 <= ny < h and 0 <= nx < w) and (graph[ny][nx] not in ['#', '*'] and not visited_fire[ny][nx]):
                q_fire.append((ny, nx))
                dist_fire[ny][nx] = dist_fire[cy][cx] + 1
                visited_fire[ny][nx] = True
    
    while q_sg and not answer:
        cy, cx = q_sg.popleft()
        for i in range(4):
            ny = cy + dy[i]
            nx = cx + dx[i]
            if (0 <= ny < h and 0 <= nx < w):
                if (graph[ny][nx] != '#' and not visited_sg[ny][nx]) and (dist_fire[ny][nx] - 1 > dist_sg[cy][cx]):
                    q_sg.append((ny, nx))
                    dist_sg[ny][nx] = dist_sg[cy][cx] + 1
                    visited_sg[ny][nx] = True
            else:
                answer = dist_sg[cy][cx] + 1
                break
        if answer:
            break
    
    if answer:
        print(answer)
    else:
        print('IMPOSSIBLE')
      
