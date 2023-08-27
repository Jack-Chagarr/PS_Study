N = int(input())

mainstar = [[' ' for _ in range(2 * N)] for _ in range(N)]
indices = [(0, 2), (1, 1), (1, 3), (2, 0), (2, 1), (2, 2), (2, 3), (2, 4)]

def starmaker(N, startpoint):
  if N == 3:
    for idx in indices:
      mainstar[startpoint[0] + idx[0]][startpoint[1] + idx[1]] = '*'

  else:
    starmaker(N//2, (startpoint[0], startpoint[1] + N//2))
    starmaker(N//2, (startpoint[0] + N//2, startpoint[1]))
    starmaker(N//2, (startpoint[0] + N//2, startpoint[1] + N))

starmaker(N, (0, 0))
for row in mainstar:
  print(''.join(row))