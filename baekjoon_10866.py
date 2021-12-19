# baekjoon_10866
from sys import stdin

N = int(stdin.readline())
li = []

for _ in range(N):
    method = stdin.readline().split()

    if method[0] == 'push_front': 
      li.insert(0, method[1])

    elif method[0] == 'push_back': 
      li.append(method[1])

    elif method[0] == 'pop_front': 
        if li: 
          print(li.pop(0))
        else: 
          print(-1)

    elif method[0] == 'pop_back': 
        if li: 
          print(li.pop())
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