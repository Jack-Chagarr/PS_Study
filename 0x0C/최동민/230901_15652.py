N, M = map(int, input().split())

num_list = [0] * M


def backtracking(K):
    if K == M:
        print(" ".join(map(str, num_list)))
        return
    for i in range(1, N + 1):
        if K == 0 or num_list[K - 1] <= i:
            num_list[K] = i

            backtracking(K + 1)


backtracking(0)
