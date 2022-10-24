import sys

N = int(sys.stdin.readline())
L = list()

for i in range(N):
    a = list(map(int,sys.stdin.readline().split()))
    L.append(a)

for i in range(N):
    count = 0
    for j in range(N):
        if L[i][0] < L[j][0] and L[i][1] < L[j][1]:
            count +=1
    print(count +1,end=' ')





