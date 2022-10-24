import sys

N = int(input())
class queue:
    def __init__(self):
        self.L =[]
    def push(self,item):
        self.L.append(item)
    def size(self): return len(self.L)
    def empty(self):
        if len(self.L)==0 : return 1
        else: return 0
    def front(self):
        if len(self.L) == 0: return -1
        else:
            return self.L[0]
         
    def back(self):
        if self.empty() == 1: return -1
        else:
            return self.L[-1]
    def pop(self):
        if self.empty() == 1: return -1
        else:
            return self.L.pop(0)
    def display(self):
        for i in range(len(self.L)):
            print(self.L[i],end=' ')

    

q = queue()

for i in range(N):
    a = list(sys.stdin.readline().strip().split())

    if a[0] == 'push':
        q.push(a[1])
    elif a[0] == 'size':
        print(q.size())
    elif a[0] == 'empty':
        print(q.empty())
    elif a[0] == 'front':
        print(q.front())
    elif a[0] == 'back':
        print(q.back())
    elif a[0] == 'pop':
        print(q.pop())


    
