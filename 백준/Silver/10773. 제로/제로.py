import sys
N = int(input())
L = list()

for i in range(N):
    n = int(sys.stdin.readline())
    if n==0: L.pop(-1)
    else:
        L.append(n)
        
sum = 0
for i in range(len(L)):
    sum +=L[i]


print(sum)
