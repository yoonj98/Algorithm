# baekjoon_10845
from sys import stdin

N = int(stdin.readline())
li = []

for _ in range(N):
    method = stdin.readline().split()

    if method[0] == 'push': 
      li.append(method[1])

    elif method[0] == 'pop': 
        if li: 
          print(li.pop(0))
        else: 
          print(-1)

    elif method[0] == 'size': 
      print(len(li))

    elif method[0] == 'empty':
        if len(li) == 0: 
          print(1)
        else: 
          print(0)
            
    elif method[0] == 'front':
        if len(li) == 0: 
          print(-1)
        else: 
          print(li[0])
    
    elif method[0] == 'back':
        if len(li) == 0: 
          print(-1)
        else: 
          print(li[-1])