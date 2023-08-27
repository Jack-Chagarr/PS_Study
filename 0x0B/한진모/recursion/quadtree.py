N = int(input())
board = [list(input()) for _ in range(N)]

def mk_paper(mtx):

    k = len(mtx)
    coord = [(0, 0), (0, 1), (1, 0), (1, 1)]

    if k == 1:
        return mtx[0][0]

    if k == 2: 
        vec = [mtx[i[0]][i[1]] for i in coord]
        zeroCount = sum([i == '0' for i in vec])
        oneCount = sum([i == '1' for i in vec])

        if zeroCount == 4:
            return '0'
        elif oneCount == 4:
            return '1'
        else:
            return '(' + ''.join(vec) + ')'

    else:
        result = mk_paper([
            [mk_paper([vec[:k//2] for vec in mtx[:k//2]]), mk_paper([vec[k//2:] for vec in mtx[:k//2]])],
            [mk_paper([vec[:k//2] for vec in mtx[k//2:]]), mk_paper([vec[k//2:] for vec in mtx[k//2:]])]
        ])
        return result

print(mk_paper(board))