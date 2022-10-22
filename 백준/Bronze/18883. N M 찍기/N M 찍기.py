import sys
N,M = map(int,sys.stdin.readline().split())
for i in range(N):
    for j in range(i*M+1,i*M+M):
        print(j,end=" ")
    print(i*M+M)