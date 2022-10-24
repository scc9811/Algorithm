import sys
N = int(input())
L = list()


for i in range(N):
    n = int(sys.stdin.readline())
    L.append(n)

L.sort()

for i in range(len(L)):
    print(L[i])
