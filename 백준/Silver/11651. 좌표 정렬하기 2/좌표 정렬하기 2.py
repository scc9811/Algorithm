import sys

n = int(sys.stdin.readline())
array = list()
for i in range(n):
    L = list(map(int,sys.stdin.readline().split()))
    L.reverse()
    array.append(L)
    
    
    
array.sort()
for i in range(n):
    print("%d %d"%(array[i][1],array[i][0]))
    
