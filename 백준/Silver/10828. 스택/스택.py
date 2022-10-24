import sys
L = list()

N = int(sys.stdin.readline())
for i in range(N):
    a = list(sys.stdin.readline().split())
    if (a[0]=="push"):
        L.append(a[1])
    elif (a[0]=="top"):
        if len(L)==0:
            print(-1)
        else:
            print(L[-1])
    elif (a[0]=="size"):
        print(len(L))
    elif (a[0]=="empty"):
        if len(L)==0:
            print(1)
        else:
            print(0)
    elif (a[0]=="pop"):
        if len(L)==0:
            print(-1)
        else:
            print(L.pop(-1))
            