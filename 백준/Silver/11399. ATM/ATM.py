N = int(input())

L = list(map(int,input().split()))

L.sort()

sum = 0
result =0
for i in range(len(L)):
    sum += L[i]


for i in range(len(L)-1,-1,-1):
    result = result + sum
    sum -= L[i]

print(result)


