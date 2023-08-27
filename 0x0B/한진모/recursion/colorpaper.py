N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
zeroNum = 0
oneNum = 0

def mk_paper(mtx):

    global zeroNum
    global oneNum

    k = len(mtx)
    coord = [(0, 0), (0, 1), (1, 0), (1, 1)]

    if k == 2: 
        vec = [mtx[i[0]][i[1]] for i in coord]
        zeroCount = sum([i == 0 for i in vec])
        oneCount = sum([i == 1 for i in vec])

        if zeroCount == 4:
            return 0
        elif oneCount == 4:
            return 1
        else:
            zeroNum += zeroCount
            oneNum += oneCount
            return -1

    else:
        quad1 = [vec[:k//2] for vec in mtx[:k//2]]
        quad2 = [vec[k//2:] for vec in mtx[:k//2]]
        quad3 = [vec[:k//2] for vec in mtx[k//2:]]
        quad4 = [vec[k//2:] for vec in mtx[k//2:]]
        
        val1 = mk_paper(quad1) 
        val2 = mk_paper(quad2) 
        val3 = mk_paper(quad3) 
        val4 = mk_paper(quad4)

        res_mtx = [[val1, val2], [val3, val4]]
        
        result = mk_paper(res_mtx)
        return result

val = mk_paper(board)

if val == 0:
    zeroNum = 1
elif val == 1:
    oneNum = 1

print(zeroNum)
print(oneNum)