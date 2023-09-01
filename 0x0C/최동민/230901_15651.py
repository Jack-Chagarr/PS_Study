N, M = map(int, input().split())

num_list = [0] * M


def backtracking(K):
    if K == M:
        print(" ".join(map(str, num_list)))
        return
    for i in range(1, N + 1):
        num_list[K] = i

        backtracking(K + 1)


backtracking(0)
