import sys

s = sys.stdin.readline().strip()
ls = list()
for i in range(len(s)):
    ls.append(s[i])
    
ls.sort(reverse=True)

for i in range(len(ls)):
    print(ls[i], end='')
