N, M = map(int, input().split())

isused = [False] * (N + 1)
num_candidate = sorted(list(map(int, input().split())))
num_list = [0] * M


def backtracking(K):
    if K == M:
        print(" ".join(map(str, num_list)))
        return
    for i in range(1, N + 1):
        if isused[i] == False:
            num_list[K] = num_candidate[i - 1]
            isused[i] = True
            backtracking(K + 1)
            isused[i] = False


backtracking(0)
