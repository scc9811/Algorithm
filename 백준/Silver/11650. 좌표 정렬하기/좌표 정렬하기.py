import sys
N = int(sys.stdin.readline())
L = list()

for i in range(N):
    ls = list(map(int,sys.stdin.readline().split()))
    L.append(ls)


L.sort()
for i in range(N):
    print(L[i][0], L[i][1])
    

