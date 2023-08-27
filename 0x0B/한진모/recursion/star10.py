N = int(input())

mainstar = [[' ' for _ in range(N)] for _ in range(N)]
indices = (0, 1, 2)

def starmaker(N, startpoint):
  if N == 1:
    mainstar[startpoint[0]][startpoint[1]] = '*'
  else:
    for i in indices:
      for j in indices:
        if not (i == 1 and j == 1):
          starmaker(N//3, (startpoint[0] + i * (N//3), startpoint[1] + j * (N//3)))

starmaker(N, (0, 0))

for row in mainstar:
  print(''.join(row))