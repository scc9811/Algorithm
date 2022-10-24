import sys

N,K = map(int,sys.stdin.readline().split())

L = list()

for i in range(N):
    L.append(int(sys.stdin.readline()))

count =0
for i in range(len(L)-1,-1,-1):
    if K==0:
        break
    while L[i] <= K:
        if L[i]*100 <=K:
            K-=L[i]*100
            count +=100
        else:
            K -= L[i]
            count +=1
        

        

        
print(count)
