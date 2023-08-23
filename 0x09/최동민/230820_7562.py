from collections import deque


def bfs():
    delta_list = [
        [1, 2],
        [-1, 2],
        [2, 1],
        [2, -1],
        [-2, 1],
        [-2, -1],
        [-1, -2],
        [1, -2],
    ]
    total_test = []

    test_num = int(input())

    for i in range(test_num):
        R = int(input())
        start_x, start_y = map(int, input().split())
        end_x, end_y = map(int, input().split())
        total_test.append([R, [start_x, start_y], [end_x, end_y]])

    # visited == 1 , unvisited == 0
    for R, start, end in total_test:
        move_cnt = 0
        visited = [[0 for i in range(R)] for j in range(R)]
        move_graph = [[0 for i in range(R)] for j in range(R)]
        queue = deque()
        queue.append(start + [0])
        visited[start[0]][start[1]] = 1
        move_graph[start[0]][start[1]] = 0
        while queue:
            xi, yi, depth = queue.popleft()
            cur_depth = depth + 1
            for delta in delta_list:
                xf = xi + delta[0]
                yf = yi + delta[1]
                if (0 <= (xf) < R) and (0 <= (yf) < R):
                    if visited[xf][yf] == 0:
                        visited[xf][yf] = 1
                        queue.append([xf, yf, cur_depth])
                        move_graph[xf][yf] = cur_depth
        print(move_graph[end[0]][end[1]])


bfs()
