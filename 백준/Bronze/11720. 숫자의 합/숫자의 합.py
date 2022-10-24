import sys
N = int(sys.stdin.readline())
a = input()

sum = 0


for i in range(len(a)):
    sum += int(a[i])

print(sum)
