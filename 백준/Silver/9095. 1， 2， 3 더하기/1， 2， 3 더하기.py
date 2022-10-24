N = int(input())

def function(n):
    if n==1:
        return 1
    elif n==2:
        return 2
    elif n ==3:
        return 4
    else:
        return function(n-1) + function(n-2) + function(n-3)
    
for i in range(N):
    n = int(input())
    print(function(n))
    
