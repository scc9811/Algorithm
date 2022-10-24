import sys
def function(n):
    k = 10
    while n//k != 0:
        k *=10
    return k//10
N = int(sys.stdin.readline())

count = 0

if N >= 99 :
    count += 99
elif N == 1000:
    print(144)
    exit(0)
else:
    print(N)
    exit(0)


for i in range(100,N+1):
    first = i//100
    i -= first*100
    second = i//10
    i -= second*10
    theard = i
    if ((first - second) == (second - theard)):
        count +=1

print(count)