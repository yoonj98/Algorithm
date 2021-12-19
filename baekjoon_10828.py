# baekjoon_10828
# input() 쓰면 시간 초과 남 ㅠㅠ
import sys

N = int(sys.stdin.readline())
li = []

for i in range(0, N):
  method = sys.stdin.readline().split()
  word = method[0]

  if word == 'push':
    li.append(method[1])
  elif word == 'pop':
    if len(li) == 0:
      print(-1)
    else:
      print(li[-1])
      li.pop()
  elif word == 'size':
    print(len(li))
  elif word == 'empty':
    if len(li) == 0:
      print(1)
    else:
      print(0)
  elif word == 'top':
    if len(li) == 0:
      print(-1)
    else:
      print(li[-1])