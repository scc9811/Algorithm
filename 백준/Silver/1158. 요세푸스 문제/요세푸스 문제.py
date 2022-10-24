L = list()
size,jump = map(int, input().split())

for i in range(size):
    L.append(i+1)

index = jump -1
print("<",end='')
while len(L)!=1:
    index = index % len(L)
    print(L.pop( index ),end=', ')
    index += jump-1

print(L.pop(0),end='')
print(">")
