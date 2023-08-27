N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
coord = [(i, j) for i in (0, 1, 2) for j in (0, 1, 2)]

moNum = 0
zeroNum = 0
oneNum = 0

def mk_paper(mtx):

    global moNum, zeroNum, oneNum

    if len(mtx) == 1:
        return mtx[0][0]

    if len(mtx) == 3:
        vec = [mtx[i[0]][i[1]] for i in coord]
        moCount = vec.count(-1)
        zeroCount = vec.count(0)
        oneCount = vec.count(1)

        if moCount == 9:
            return -1
        elif zeroCount == 9:
            return 0
        elif oneCount == 9:
            return 1
        else:
            moNum += moCount
            zeroNum += zeroCount
            oneNum += oneCount
            return -2
        
    else:
        n = len(mtx)//3
        val = mk_paper([[mk_paper([vec[:n] for vec in mtx[:n]]), mk_paper([vec[n:2*n] for vec in mtx[:n]]), mk_paper([vec[2*n:] for vec in mtx[:n]])],
                        [mk_paper([vec[:n] for vec in mtx[n:2*n]]), mk_paper([vec[n:2*n] for vec in mtx[n:2*n]]), mk_paper([vec[2*n:] for vec in mtx[n:2*n]])],
                        [mk_paper([vec[:n] for vec in mtx[2*n:]]), mk_paper([vec[n:2*n] for vec in mtx[2*n:]]), mk_paper([vec[2*n:] for vec in mtx[2*n:]])]
                        ])
        return val
    
result = mk_paper(board)
if result == -1:
    moNum = 1
elif result == 0:
    zeroNum = 1
elif result == 1:
    oneNum = 1

print(moNum, zeroNum, oneNum, sep = '\n')