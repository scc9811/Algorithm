n = int(input())

for i in range(n):
    k = list(map(int,input().split()))
    result = k[0] + k[1]
    print("Case #%d: %d" %(i+1,result))
    
    
